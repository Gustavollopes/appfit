package com.appfit.activities.service;


import com.appfit.activities.dto.ActivityRequestDTO;
import com.appfit.activities.model.Activity;
import com.appfit.activities.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;

    public Activity criarAtividade(ActivityRequestDTO dto) {
        Activity activity = new Activity();
        return activityRepository.save(activity);

    }
    public List<Activity> buscarTodas() {
        // O findAll() é um superpoder do JpaRepository.
        // Ele faz um "SELECT * FROM activities" no MySQL automaticamente!
        return activityRepository.findAll();}
}