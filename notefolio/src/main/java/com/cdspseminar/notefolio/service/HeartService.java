package com.cdspseminar.notefolio.service;

import com.cdspseminar.notefolio.common.exception.BusinessException;
import com.cdspseminar.notefolio.common.exception.ErrorStatus;
import com.cdspseminar.notefolio.domain.Creative;
import com.cdspseminar.notefolio.domain.Creator;
import com.cdspseminar.notefolio.domain.Heart;
import com.cdspseminar.notefolio.dto.request.HeartCreateRequest;
import com.cdspseminar.notefolio.repository.CreativeRepository;
import com.cdspseminar.notefolio.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HeartService {
    private final HeartRepository heartRepository;
    private final CreativeRepository creativeRepository;
    @Transactional
    public void createHeart(Long creatorId, HeartCreateRequest heartCreateRequest){
        Creator creator = new Creator(creatorId, "김솝트");
        Creative creative = creativeRepository.findById(heartCreateRequest.creativeId())
                .orElseThrow(
                        () -> new BusinessException(ErrorStatus.CREATIVE_NOT_FOUND)
                );
        Heart heart = Heart.builder()
                .creator(creator)
                .creative(creative)
                .build();
        heartRepository.save(heart);
        creative.increaseNumLike();
    }
}
