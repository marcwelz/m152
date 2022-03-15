package com.ch.bbw.mw.backend.controller;

import com.ch.bbw.mw.backend.model.ImageM152;
import com.ch.bbw.mw.backend.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/m152")
public class Controller {

    private final Service service;

    @GetMapping(value = "/{filename}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ImageM152 getImageByFilename(@PathVariable String filename) {
        return service.getImageByFilename(filename);
    }

    @GetMapping(value = "/{sector}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ImageM152> getImagesBySector(@PathVariable String sector) {
        return service.getImagesBySector(sector);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean addImage(@RequestBody ImageM152 imageM152) {
        return service.addImage(imageM152);
    }
}
