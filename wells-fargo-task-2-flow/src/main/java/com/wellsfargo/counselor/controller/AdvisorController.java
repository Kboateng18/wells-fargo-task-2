package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Advisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wellsfargo.counselor.service.AdvisorService;

import java.util.List;

@RestController
@RequestMapping("/api/advisors")
public class AdvisorController {

    @Autowired
    private AdvisorService advisorService;

    @GetMapping
    public ResponseEntity<List<Advisor>> getAllAdvisors() {
        return ResponseEntity.ok(advisorService.getAllAdvisors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advisor> getAdvisorById(@PathVariable Long id) {
        return ResponseEntity.ok(advisorService.getAdvisorById(id));
    }

    @PostMapping
    public ResponseEntity<Advisor> createAdvisor(@RequestBody Advisor advisor) {
        return ResponseEntity.ok(advisorService.createAdvisor(advisor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advisor> updateAdvisor(@PathVariable Long id, @RequestBody Advisor advisor) {
        return ResponseEntity.ok(advisorService.updateAdvisor(id, advisor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvisor(@PathVariable Long id) {
        advisorService.deleteAdvisor(id);
        return ResponseEntity.ok().build();
    }
}