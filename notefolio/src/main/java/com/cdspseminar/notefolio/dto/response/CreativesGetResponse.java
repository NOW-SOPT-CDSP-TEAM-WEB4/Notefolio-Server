package com.cdspseminar.notefolio.dto.response;

import com.cdspseminar.notefolio.domain.Creative;
import com.cdspseminar.notefolio.repository.HeartRepository;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record CreativesGetResponse(
    List<CreativeGetResponse> creatives
) {
    public static CreativesGetResponse of(List<Creative> creatives, HeartRepository heartRepository) {
        return CreativesGetResponse.builder().creatives(creatives.stream()
               .map(creative -> {
                   boolean isLike = heartRepository.findByCreatorIdAndCreativeId(1L, creative.getId()).isPresent();
                       return CreativeGetResponse.builder()
                               .name(creative.getCreator().getName())
                               .creativeId(creative.getId())
                               .view(creative.getView())
                               .like(creative.getNumLike())
                               .isLike(isLike)
                               .build();
                   }
               )
               .toList())
               .build();
    }
}
