package com.ch.bbw.mw.backend.service;

import com.ch.bbw.mw.backend.model.ImageM152;
import com.ch.bbw.mw.backend.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

    private Repository repository;

    public void addImage(ImageM152 imageM152) {
        repository.save(imageM152);
    }

    public List<ImageM152> getImagesBySector(String sector) {
        return null;
    }

    public ImageM152 getImageByFilename(String filename) {
        return null;
    }
}
