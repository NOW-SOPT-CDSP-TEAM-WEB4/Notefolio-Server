package com.cdspseminar.notefolio.repository;

import com.cdspseminar.notefolio.domain.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
