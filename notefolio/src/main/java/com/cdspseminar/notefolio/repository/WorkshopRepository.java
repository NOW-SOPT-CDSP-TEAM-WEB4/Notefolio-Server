package com.cdspseminar.notefolio.repository;

import com.cdspseminar.notefolio.domain.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
