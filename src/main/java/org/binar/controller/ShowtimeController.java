package org.binar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.binar.exception.ExceptionResponse;
import org.binar.model.Showtime;
import org.binar.payload.ApiResponse;
import org.binar.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/showtime", produces = {"application/json"})
public class ShowtimeController {
    @Autowired
    ShowtimeService showtimeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Showtime addShowtime(@RequestBody Showtime showtime) {
        return showtimeService.addShowtime(showtime);
    }

    @PostMapping("/createbulk")
    public List<Showtime> addManyShowtime(@RequestBody List<Showtime> manyShowtime) {
        return showtimeService.addManyShowtime(manyShowtime);
    }

    @GetMapping("/showtoday")
    public List<Showtime> getFilmShowingToday() {
        return showtimeService.getFilmShowingToday();
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
    public List<Showtime> getShowtime() {
        return showtimeService.getAllShowtime();
    }

    @PutMapping("/update/{id}")
    public String updateShowtime(@PathVariable Long id, @RequestBody Showtime showtime) {
        showtimeService.updateShowtime(id, showtime);
        return "Showtime with id " + id + " updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return "Showtime with id " + id + " deleted";
    }
}
