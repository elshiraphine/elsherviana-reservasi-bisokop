package org.binar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.binar.exception.ExceptionResponse;
import org.binar.payload.ApiResponse;
import org.binar.model.Film;
import org.binar.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/film", produces = {"application/json"})
public class FIlmController {
    @Autowired
    FilmService filmService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Film createFilm(@RequestBody Film film) {
        return filmService.addFilm(film);
    }

    @PostMapping("/createbulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Film> createFilms(@RequestBody List<Film> films) {
        return filmService.addFilms(films);
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
    public List<Film> getAll() {
        return filmService.getAllFilm();
    }

    @GetMapping("/id/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }

    @GetMapping("/ongoing")
    public List<Film> getOnGoing() {
        return filmService.filmShowing();
    }

    @PutMapping("/update/{id}")
    public Optional<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        filmService.updateFilm(film, id);
        return filmService.getFilmById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return "Film with id " + id + " deleted";
    }
}
