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
public class Controller {

    private final Service service;

    @GetMapping(value = "/filename/{filename}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ImageM152> getImageByFilename(@PathVariable String filename) {
        return service.getImageByFilename(filename);
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
}
