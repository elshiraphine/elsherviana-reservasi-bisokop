package org.binar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.binar.exception.ExceptionResponse;
import org.binar.model.Schedule;
import org.binar.payload.ApiResponse;
import org.binar.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @Operation(
        tags = {"Film"},
        operationId = "getAllFilm",
        summary = " Get All Film Data",
        responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "200",
                content = @Content(
                        schema = @Schema(implementation = ApiResponse.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                ),
                description = "Success Response."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "400",
                content = @Content(
                        schema = @Schema(implementation = ExceptionResponse.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                ),
                description = "Bad Request"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "405",
                content = @Content(
                        schema = @Schema(implementation = ExceptionResponse.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                ),
                description = "Method Not Allowed"
            )
        }
    )
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
