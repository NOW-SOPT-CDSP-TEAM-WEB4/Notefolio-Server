package com.cdspseminar.notefolio.repository;

import com.cdspseminar.notefolio.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {
}
