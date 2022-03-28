package com.ch.bbw.mw.backend.service;

import com.ch.bbw.mw.backend.model.ImageM152;
import com.ch.bbw.mw.backend.repository.Repository;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

    private final String pathname = "/Users/marcwelz/Library/Mobile Documents/com~apple~CloudDocs/Schule/BBW/Modul 152/m152/images";
    private final Repository repository;

    public void addImage(ImageM152 imageM152) {
        repository.save(imageM152);
    }

    public Collection<ImageM152> getImageByFilename(String filename) {
        return repository.findAllByFilename(filename);
    }

    public void deleteImage(String filename) {
        repository.deleteImageM152(filename);
    }

    public void updateImageM152(String oldFilename, String newFilename) {
        repository.updateImageM152(oldFilename, newFilename);
    }

    public void convertImagesAndImportToDb() throws IOException {
        List<String> results = new ArrayList<String>();
        String directoryPath = pathname + "/images";

        File[] files = new File(directoryPath).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }

        for(String filename : results) {
            byte[] fileContent = FileUtils.readFileToByteArray(new File(directoryPath + "/" + filename));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);

            repository.save(new ImageM152(filename, encodedString));
        }
    }

    public ImageM152 addWatermarkToImage(String filename) throws IOException {
        String destImageFilePath = pathname + "/watermark/" + filename.split("\\.")[0] + "_watermark";
        File destImageFile = new File(destImageFilePath);

        Collection<ImageM152> imageM152 = getImageByFilename(filename);
        ImageM152 image = imageM152.iterator().next();

        if(imageM152.isEmpty()) return null;

        byte[] decodedBytes = Base64.getDecoder().decode(image.getBase64ImageString());

        String sourceImageFilePath = pathname + "/images/watermark_" + filename;
        FileUtils.writeByteArrayToFile(new File(sourceImageFilePath), decodedBytes);
        File sourceImageFile = new File(sourceImageFilePath);

        addTextWatermark("©Marc Welz", sourceImageFile, destImageFile);

        Files.delete(Path.of(pathname + "/images/watermark_" + filename));

        byte[] fileContent = FileUtils.readFileToByteArray(new File(destImageFilePath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return new ImageM152("watermark_" + filename, encodedString);
    }

    private void addTextWatermark(String text, File sourceImageFile, File destImageFile) {
        try {
            BufferedImage sourceImage = ImageIO.read(sourceImageFile);
            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
            g2d.setComposite(alphaChannel);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 256));
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

            int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
            int centerY = sourceImage.getHeight() / 2;

            g2d.drawString(text, centerX, centerY);

            ImageIO.write(sourceImage, "png", destImageFile);
            g2d.dispose();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void convertPNGtoJPEG(String filename) throws IOException {
        Path source = Paths.get(pathname + "/images/" + filename);
        Path target = Paths.get(pathname + "/converted_to_jpeg/" + filename);

        BufferedImage originalImage = ImageIO.read(source.toFile());

        BufferedImage newBufferedImage = new BufferedImage(
                originalImage.getWidth(),
                originalImage.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        newBufferedImage.createGraphics()
                .drawImage(originalImage,
                        0,
                        0,
                        Color.WHITE,
                        null);

        ImageIO.write(newBufferedImage, "jpg", target.toFile());
    }
}
