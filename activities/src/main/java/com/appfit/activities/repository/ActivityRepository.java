package com.appfit.activities.repository;

import com.appfit.activities.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {


    List<Activity> findByUserId(Long userId);

}


