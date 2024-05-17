package com.cdspseminar.notefolio.controller;

import com.cdspseminar.notefolio.common.ApiResponse;
import com.cdspseminar.notefolio.common.SuccessStatus;
import com.cdspseminar.notefolio.dto.request.HeartCreateRequest;
import com.cdspseminar.notefolio.service.HeartService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heart")
@RequiredArgsConstructor
public class HeartController {
    private final HeartService heartService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createHeart(
            @RequestHeader Long creatorId,
            @RequestHeader Long creativeId,
            @RequestBody HeartCreateRequest heartCreateRequest
    ){
        return ApiResponse.success(SuccessStatus.CREATED);
    }
}
