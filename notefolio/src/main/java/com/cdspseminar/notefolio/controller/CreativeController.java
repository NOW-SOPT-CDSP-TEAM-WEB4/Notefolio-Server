package com.cdspseminar.notefolio.controller;

import com.cdspseminar.notefolio.common.ApiResponse;
import com.cdspseminar.notefolio.common.SuccessStatus;
import com.cdspseminar.notefolio.dto.response.CreativesGetResponse;
import com.cdspseminar.notefolio.service.CreativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/creatives")
@RequiredArgsConstructor
@RestController
public class CreativeController {
    private final CreativeService creativeService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getCreatives() {
        final CreativesGetResponse response = creativeService.getCreatives();
        return ApiResponse.success(SuccessStatus.OK, response);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<?>> searchCreatives(@RequestParam String word) {
        final CreativesGetResponse response = creativeService.searchCreatives(word);
        return ApiResponse.success(SuccessStatus.OK, response);
    }

//    createAt, updateAt 잘되는지 테스트용으로 그냥 만들어봤어요 잘됩니다.
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createCreatives() {
        creativeService.createCreative();
        return ApiResponse.success(SuccessStatus.CREATED);
    }
}
