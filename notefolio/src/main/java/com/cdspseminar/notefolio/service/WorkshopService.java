package com.cdspseminar.notefolio.service;

import com.cdspseminar.notefolio.domain.Workshop;
import com.cdspseminar.notefolio.dto.response.WorkshopsGetResponse;
import com.cdspseminar.notefolio.repository.WorkshopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkshopService {
    private final WorkshopRepository workshopRepository;

    public WorkshopsGetResponse getWorkshops() {
        List<Workshop> workshops = workshopRepository.findAll();
        List<Workshop> limitedWorkshops = workshops.size() > 3? workshops.subList(0, 3) : workshops;
        return WorkshopsGetResponse.of(limitedWorkshops);
    }
}
