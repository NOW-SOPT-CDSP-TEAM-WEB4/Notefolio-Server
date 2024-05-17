package com.cdspseminar.notefolio.controller;

import com.cdspseminar.notefolio.common.ApiResponse;
import com.cdspseminar.notefolio.common.SuccessStatus;
import com.cdspseminar.notefolio.dto.response.ProgramsFindResponse;
import com.cdspseminar.notefolio.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programs")
@RequiredArgsConstructor
public class ProgramController {
    private final ProgramService programService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> findPrograms(){
        final ProgramsFindResponse response = programService.getPrograms();
        return ApiResponse.success(SuccessStatus.OK,response);
    }
}
