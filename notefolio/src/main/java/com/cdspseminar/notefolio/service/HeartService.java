package com.cdspseminar.notefolio.service;

import com.cdspseminar.notefolio.dto.request.HeartCreateRequest;
import com.cdspseminar.notefolio.repository.HeartRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HeartService {
    private final HeartRepository heartRepository;

    @Transactional
    public void createHeart(HeartCreateRequest heartCreateRequest){

    }
}
