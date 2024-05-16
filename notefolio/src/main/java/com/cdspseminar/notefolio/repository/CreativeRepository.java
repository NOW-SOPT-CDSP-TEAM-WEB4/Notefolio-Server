package com.cdspseminar.notefolio.repository;

import com.cdspseminar.notefolio.domain.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
