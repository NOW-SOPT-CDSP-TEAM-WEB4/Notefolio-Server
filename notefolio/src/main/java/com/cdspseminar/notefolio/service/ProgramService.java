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
        return ProgramsFindResponse.of(programs);
    }
    public List<Program> findPrograms(){
        return programRepository.findAll();
    }
}
