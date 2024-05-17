package com.cdspseminar.notefolio.dto.response;

import com.cdspseminar.notefolio.domain.Creative;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record CreativesGetResponse(
    List<CreativeGetResponse> creatives
) {
    public static CreativesGetResponse of(List<Creative> creatives) {
        return CreativesGetResponse.builder().creatives(creatives.stream()
               .map(creative -> CreativeGetResponse.builder()
                       .name(creative.getCreator().getName())
                       .creativeId(creative.getId())
                       .view(creative.getView())
                       .like(creative.getNumLike())
                       .build())
               .toList())
               .build();
    }
}
