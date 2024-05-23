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
            @RequestBody HeartCreateRequest heartCreateRequest
    ){
        heartService.createHeart(heartCreateRequest);
        return ApiResponse.success(SuccessStatus.CREATED);
    }

    @DeleteMapping("/{creativeId}")
    public ResponseEntity<ApiResponse<?>> deleteHeart(
            @PathVariable Long creativeId
    ){
        heartService.deleteHeart(creativeId);
        return ApiResponse.success(SuccessStatus.OK);
    }
}
