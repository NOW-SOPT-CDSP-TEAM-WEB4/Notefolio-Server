package com.cdspseminar.notefolio.dto.request;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PROTECTED)
public record HeartCreateRequest(Long creativeId) {
}
