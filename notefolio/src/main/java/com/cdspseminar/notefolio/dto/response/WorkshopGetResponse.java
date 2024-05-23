package com.cdspseminar.notefolio.dto.response;

import lombok.AccessLevel;
import lombok.Builder;


@Builder(access = AccessLevel.PROTECTED)
public record WorkshopGetResponse(
        Long workshopId,
        String title,
        String content,
        String date,
        boolean online
) {
}
