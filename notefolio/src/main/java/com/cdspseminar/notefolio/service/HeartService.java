package com.cdspseminar.notefolio.service;

import com.cdspseminar.notefolio.common.exception.BusinessException;
import com.cdspseminar.notefolio.common.exception.ErrorStatus;
import com.cdspseminar.notefolio.domain.Creative;
import com.cdspseminar.notefolio.domain.Creator;
import com.cdspseminar.notefolio.domain.Heart;
import com.cdspseminar.notefolio.dto.request.HeartCreateRequest;
import com.cdspseminar.notefolio.repository.CreativeRepository;
import com.cdspseminar.notefolio.repository.CreatorRepository;
import com.cdspseminar.notefolio.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeartService {
    private final HeartRepository heartRepository;
    private final CreativeRepository creativeRepository;
    private final CreatorRepository creatorRepository;
    private static final Long STANDARD_CREATOR_ID = 1L;

    @Transactional
    public void createHeart(HeartCreateRequest heartCreateRequest){
        Creator creator = creatorRepository.findById(STANDARD_CREATOR_ID)

                .orElseThrow(
                        () -> new BusinessException(ErrorStatus.CREATOR_NOT_FOUND)
                );
        Creative creative = creativeRepository.findById(heartCreateRequest.creativeId())
                .orElseThrow(
                        () -> new BusinessException(ErrorStatus.CREATIVE_NOT_FOUND)
                );
        heartRepository.findByCreatorIdAndCreativeId(STANDARD_CREATOR_ID, heartCreateRequest.creativeId())
                .ifPresent(heart -> {
                    throw new BusinessException(ErrorStatus.HEART_ALREADY_EXISTS);
                });

        Heart heart = Heart.builder()
                .creator(creator)
                .creative(creative)
                .build();
        heartRepository.save(heart);
        creative.increaseNumLike();
    }

    @Transactional
    public void deleteHeart(Long creativeId) {
        Creative creative = creativeRepository.findById(creativeId)
                .orElseThrow(
                        () -> new BusinessException(ErrorStatus.CREATIVE_NOT_FOUND)
                );

        Optional<Heart> heart = heartRepository.findByCreatorIdAndCreativeId(STANDARD_CREATOR_ID, creativeId);
        if (heart.isEmpty()){
            throw new BusinessException(ErrorStatus.HEART_NOT_FOUND);
        }
        heartRepository.deleteById(heart.get().getId());
        creative.decreaseNumLike();
    }
}
