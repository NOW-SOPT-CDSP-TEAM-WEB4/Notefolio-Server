package com.cdspseminar.notefolio.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PROTECTED)
public record CreativeGetResponse(
        String name,
        long creativeId,
        long view,
        long like,
        boolean isLike
) {


}
