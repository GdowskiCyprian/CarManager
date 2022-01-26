package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.repositories.RepairPartRepository;
import com.engineer.carmanager.repositories.RepairRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RepairPartServiceImplTest {
    @InjectMocks
    RepairPartServiceImpl repairPartServiceImpl;
    @Mock
    RepairPartRepository repairPartRepository;
    @Mock
    RepairRepository repairRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repairPartServiceImpl = new RepairPartServiceImpl(repairPartRepository, repairRepository);
    }

    @Test
    void postRepairPart() {
        Repair repair = new Repair();
        repair.setIdRepair(1L);
        List<Repair> repairList = new ArrayList<>();
        repairList.add(repair);
        when(repairRepository.findAll()).thenReturn(repairList);
        assertEquals("Repair part saved", repairPartServiceImpl.postRepairPart("name", "desc", 12D, 1L));
        assertEquals("Repair part save unsuccessful", repairPartServiceImpl.postRepairPart("name", "desc", 12D, 2L));
    }

    @Test
    void deleteRepairPart() {
        //verify(repairRepository).deleteById(anyLong());
        assertEquals("Repair part deleted", repairPartServiceImpl.deleteRepairPart(1L));
    }
}