package com.ch.bbw.mw.backend.controller;

import com.ch.bbw.mw.backend.model.ImageM152;
import com.ch.bbw.mw.backend.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/m152")
@CrossOrigin()
public class Controller {

    private final Service service;

    @GetMapping(value = "/filename/{filename}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ImageM152 getImageByFilename(@PathVariable String filename) {
        Collection<ImageM152> imageM152 = service.getImageByFilename(filename);
        return imageM152.iterator().next();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addImage(@RequestBody ImageM152 imageM152) {
        service.addImage(imageM152);
    }

    @DeleteMapping(value = "/delete/{filename}")
    public void deleteImage(@PathVariable String filename) {
        service.deleteImage(filename);
    }

    @PutMapping(value = "/update/{oldFilename}/{newFilename}")
    public void deleteImage(@PathVariable String oldFilename, @PathVariable String newFilename) {
        service.updateImageM152(oldFilename, newFilename);
    }

    @GetMapping(value = "/convert")
    public void convert() throws IOException {
        service.convertImagesAndImportToDb();
    }

    @GetMapping(value = "/convert/{filename}")
    public ImageM152 addWatermarkToImage(@PathVariable String filename) throws IOException {
        return service.addWatermarkToImage(filename);
    }

    @GetMapping(value = "/convert/png/{filename}")
    public void convertPNGtoJPEG(@PathVariable String filename) throws IOException {
        service.convertPNGtoJPEG(filename);
    }

    @GetMapping(value = "/fileupload/{filename}")
    public void randomImageUpload(@PathVariable String filename) {
        Collection<ImageM152> imageM152 = service.getImageByFilename("IMG_00286.JPG");
        ImageM152 imageM1521_1 = imageM152.iterator().next();
        imageM152 = null;
        imageM152 = service.getImageByFilename("IMG_00423.JPG");
        ImageM152 imageM1521_2 = imageM152.iterator().next();
        service.addImage(new ImageM152(filename, imageM1521_1.getBase64ImageString()));
        service.addImage(new ImageM152("bild_25423.jpg", imageM1521_2.getBase64ImageString()));
    }
}
