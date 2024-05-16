package com.cdspseminar.notefolio.repository;

import com.cdspseminar.notefolio.domain.Creative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreativeRepository extends JpaRepository<Creative, Long> {

    @Query("SELECT c FROM Creative c WHERE c.creator.name LIKE %?1%")
    List<Creative> findByCreatorNameContaining(String name);
}
