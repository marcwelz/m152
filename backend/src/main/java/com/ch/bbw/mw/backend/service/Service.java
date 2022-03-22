package com.ch.bbw.mw.backend.service;

import com.ch.bbw.mw.backend.model.ImageM152;
import com.ch.bbw.mw.backend.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.Collection;

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
}
