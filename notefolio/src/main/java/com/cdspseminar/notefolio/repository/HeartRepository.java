package com.cdspseminar.notefolio.repository;

import com.cdspseminar.notefolio.domain.Creative;
import com.cdspseminar.notefolio.domain.Creator;
import com.cdspseminar.notefolio.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByCreatorIdAndCreativeId(Long creatorId, Long creativeId);
}