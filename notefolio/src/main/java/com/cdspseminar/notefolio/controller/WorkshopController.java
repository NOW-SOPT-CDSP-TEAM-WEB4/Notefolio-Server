package com.cdspseminar.notefolio.controller;

import com.cdspseminar.notefolio.common.ApiResponse;
import com.cdspseminar.notefolio.common.SuccessStatus;
import com.cdspseminar.notefolio.dto.response.WorkshopsGetResponse;
import com.cdspseminar.notefolio.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/workshops")
@RequiredArgsConstructor
@RestController
public class WorkshopController {
    private final WorkshopService workshopService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getWorkshops() {
        final WorkshopsGetResponse response = workshopService.getWorkshops();
        return ApiResponse.success(SuccessStatus.OK, response);
    }
}
