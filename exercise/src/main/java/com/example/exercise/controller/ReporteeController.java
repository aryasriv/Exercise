package com.example.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exercise.entity.Reportee;
import com.example.exercise.repository.ReporteeRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ReporteeController {

    @Autowired
    private ReporteeRepository reporteeRepository;

    @GetMapping("/reportees")
    public List<Reportee> getAllReportees() {
        return reporteeRepository.findAll();
    }

    @GetMapping("/reportee")
    public ResponseEntity<Reportee> getReporteeById(@RequestParam("id") Long id) {
        Optional<Reportee> reportee = reporteeRepository.findById(id);
        return reportee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/reportee")
    public List<Reportee> getReporteesWithLimit(@RequestParam("LIMIT") int limit) {
        return reporteeRepository.findTopN(limit);
    }
}

