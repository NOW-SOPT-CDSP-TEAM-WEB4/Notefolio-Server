package com.cdspseminar.notefolio.controller;

import com.cdspseminar.notefolio.common.ApiResponse;
import com.cdspseminar.notefolio.common.SuccessStatus;
import com.cdspseminar.notefolio.dto.request.HeartCreateRequest;
import com.cdspseminar.notefolio.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creatives/heart")
@RequiredArgsConstructor
public class HeartController {
    private final HeartService heartService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createHeart(
            @RequestHeader Long creatorId,
            @RequestBody HeartCreateRequest heartCreateRequest
    ){
        heartService.createHeart(creatorId, heartCreateRequest);
        return ApiResponse.success(SuccessStatus.CREATED);
    }
}
