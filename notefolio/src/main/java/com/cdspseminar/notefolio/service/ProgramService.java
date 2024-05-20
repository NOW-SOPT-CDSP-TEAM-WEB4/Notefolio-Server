package com.cdspseminar.notefolio.service;

import com.cdspseminar.notefolio.common.exception.BusinessException;
import com.cdspseminar.notefolio.common.exception.ErrorStatus;
import com.cdspseminar.notefolio.domain.Program;
import com.cdspseminar.notefolio.dto.response.ProgramsFindResponse;
import com.cdspseminar.notefolio.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

    public ProgramsFindResponse getPrograms(){
        List<Program> programs = findPrograms();
        if(programs.isEmpty()){
            throw new BusinessException(ErrorStatus.PROGRAMS_NOT_FOUND);
        }
        List<Program> limitedPrograms = programs.size() > 4 ? programs.subList(0, 4) : programs;
        return ProgramsFindResponse.of(limitedPrograms);
    }

    public List<Program> findPrograms(){
        return programRepository.findAll();
    }
}
