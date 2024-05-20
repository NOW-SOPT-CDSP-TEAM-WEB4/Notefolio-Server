package com.cdspseminar.notefolio.service;

import com.cdspseminar.notefolio.domain.Creative;
import com.cdspseminar.notefolio.dto.response.CreativesGetResponse;
import com.cdspseminar.notefolio.repository.CreativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreativeService {
    private final CreativeRepository creativeRepository;

    public CreativesGetResponse getCreatives() {
        List<Creative> creatives = creativeRepository.findAll();
        List<Creative> limitedCreatives = creatives.size() > 5 ? creatives.subList(0, 5) : creatives;
        return CreativesGetResponse.of(limitedCreatives);
    }

    public CreativesGetResponse searchCreatives(String word) {
        List<Creative> creatives = creativeRepository.findByCreatorNameContaining(word);
        List<Creative> limitedCreatives = creatives.size() > 16 ? creatives.subList(0, 16) : creatives;
        return CreativesGetResponse.of(limitedCreatives);
    }

    @Transactional
    public void createCreative(){
        Creative creative = Creative.builder().view(3L).numLike(4L).build();
        creativeRepository.save(creative);
    }
}
