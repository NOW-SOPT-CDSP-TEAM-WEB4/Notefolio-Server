package com.cdspseminar.notefolio.repository;

import com.cdspseminar.notefolio.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
