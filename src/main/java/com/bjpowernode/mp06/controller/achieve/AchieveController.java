package com.bjpowernode.mp06.controller.achieve;

import com.bjpowernode.mp06.entity.Achievement;
import com.bjpowernode.mp06.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AchieveController {
    @Autowired
    private IAchievementService achievementService;

    @GetMapping("findAllAchievement")
    public List<Achievement> findAll() {
        List<Achievement> achievements = achievementService.selectAll();
        return achievements;
    }
}
