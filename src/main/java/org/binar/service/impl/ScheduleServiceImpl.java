package org.binar.service.impl;

import org.binar.model.Schedule;
import org.binar.repository.ScheduleRepository;
import org.binar.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> addSchedules(List<Schedule> schedules) {
        return scheduleRepository.saveAll(schedules);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public void updateSchedule(Long scheduleId, Schedule schedule) {
        Schedule scheduleById = scheduleRepository.findById(scheduleId).orElseThrow();
        scheduleById.setStartTime(schedule.getStartTime());
        scheduleById.setEndTime(schedule.getEndTime());
        scheduleRepository.save(scheduleById);
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        try {
            scheduleRepository.deleteById(scheduleId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
