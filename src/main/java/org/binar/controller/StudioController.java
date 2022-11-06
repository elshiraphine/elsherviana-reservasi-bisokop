package org.binar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.binar.exception.ExceptionResponse;
import org.binar.model.Studio;
import org.binar.payload.ApiResponse;
import org.binar.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/studio", produces = {"application/json"})
public class StudioController {
    @Autowired
    StudioService studioService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Studio createStudio (@RequestBody Studio studio) {
        return studioService.addStudio(studio);
    }

    @PostMapping("/createbulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Studio> createStudios (@RequestBody List<Studio> studios) {
        return studioService.addStudios(studios);
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
    public List<Studio> getAll() {
        return studioService.getAllStudio();
    }

    @PutMapping("/update/{id}")
    public String updateStudio(@PathVariable Long id, @RequestBody Studio studio) {
        studioService.updateStudio(studio, id);
        return "Studio with id " + id + " updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        studioService.deleteStudio(id);
        return "Studio with id " + id + " deleted";
    }
}
