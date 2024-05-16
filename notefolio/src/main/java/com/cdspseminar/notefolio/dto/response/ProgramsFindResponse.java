package com.cdspseminar.notefolio.dto.response;

import com.cdspseminar.notefolio.domain.Program;
import lombok.Builder;

import java.util.List;

@Builder
public record ProgramsFindResponse(List<Program> programs) {
    public static ProgramsFindResponse of(List<Program> programs){
        return ProgramsFindResponse.builder()
                .programs(programs)
                .build();
    }
}
