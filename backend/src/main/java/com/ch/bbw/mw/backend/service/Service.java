package com.ch.bbw.mw.backend.service;

import com.ch.bbw.mw.backend.model.ImageM152;
import com.ch.bbw.mw.backend.repository.Repository;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

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
        String directoryPath = "/Users/marcwelz/Library/Mobile Documents/com~apple~CloudDocs/Schule/BBW/Modul 152/m152/images/images";

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
}
