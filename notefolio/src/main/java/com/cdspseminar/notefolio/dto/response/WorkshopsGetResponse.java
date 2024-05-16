package com.cdspseminar.notefolio.dto.response;

import com.cdspseminar.notefolio.domain.Workshop;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record WorkshopsGetResponse(
        List<WorkshopGetResponse> workshops
) {
    public static WorkshopsGetResponse of(List<Workshop> workshops) {
        return WorkshopsGetResponse.builder().workshops(workshops.stream()
                .map(workshop -> WorkshopGetResponse.builder()
                        .title(workshop.getTitle())
                        .content(workshop.getContent())
                        .date(workshop.getDate())
                        .online(workshop.isOnline())
                        .build())
                .toList())
                .build();
    }
}
