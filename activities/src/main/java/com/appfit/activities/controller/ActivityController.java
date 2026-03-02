package com.appfit.activities.controller;

import com.appfit.activities.dto.ActivityRequestDTO;
import com.appfit.activities.model.Activity;
import com.appfit.activities.service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<Activity> criarActivity(@RequestBody @Valid ActivityRequestDTO dto) {
        Activity savedActivity = activityService.criarAtividade(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);
    }

    @GetMapping
    public ResponseEntity<List<Activity>> listarActivities() {
        //List<Activity>activities = activityService.listarAtividadesPorUsuario(userId);
        List<Activity>activities = activityService.buscarTodas();
        return ResponseEntity.ok(activities);
    }
}
