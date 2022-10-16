package org.binar.service;

import org.binar.model.Schedule;

import java.util.List;

public interface ScheduleService {
    public Schedule addSchedule (Schedule schedule);
    public List<Schedule> addSchedules (List<Schedule> schedules);
    public List<Schedule> getAllSchedules();
    public void updateSchedule(Long scheduleId, Schedule schedule);
    public void deleteSchedule(Long scheduleId);
}
