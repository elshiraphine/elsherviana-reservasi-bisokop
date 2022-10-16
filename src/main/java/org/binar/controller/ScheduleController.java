package org.binar.controller;

import org.binar.model.Schedule;
import org.binar.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedule", produces = {"application/json"})
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule createSchedule (@RequestBody Schedule schedule) {
        return scheduleService.addSchedule(schedule);
    }

    @PostMapping("/createbulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Schedule> createSchedule (@RequestBody List<Schedule> schedules) {
        return scheduleService.addSchedules(schedules);
    }

    @GetMapping("/getall")
    public List<Schedule> getAll() {
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/update/{id}")
    public String updateSchedule (@PathVariable Long id, @RequestBody Schedule schedule) {
        scheduleService.updateSchedule(id, schedule);
        return "Schedule with id " + id + " updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return  "Schedule with id " + id + " deleted";
    }
}
