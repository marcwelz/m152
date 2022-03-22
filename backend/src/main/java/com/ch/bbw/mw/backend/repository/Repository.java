package com.ch.bbw.mw.backend.repository;

import com.ch.bbw.mw.backend.model.ImageM152;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<ImageM152, Integer> {

    @Query("SELECT i FROM ImageM152 i WHERE i.filename = :filename")
    Collection<ImageM152> findAllByFilename(@Param("filename") String filename);

    @Modifying
    @Transactional
    @Query("DELETE FROM ImageM152 i WHERE i.filename = :filename")
    void deleteImageM152(@Param("filename") String filename);
}

