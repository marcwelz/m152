package com.ch.bbw.mw.backend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images_m152")

@RequiredArgsConstructor
@Getter
@Setter
public class ImageM152 {

    @Id
    @Column(name = "filename")
    private String filename;

    @Column(name = "section")
    private String section;

    @Column(name = "base64_image_string")
    private String base64ImageString;

}
