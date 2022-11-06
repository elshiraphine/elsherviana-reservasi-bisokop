package org.binar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.binar.exception.ExceptionResponse;
import org.binar.model.Users;
import org.binar.payload.ApiResponse;
import org.binar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user", produces = {"application/json"})
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PostMapping("/createbulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Users> createUser(@RequestBody List<Users> users) {
        return userService.addUsers(users);
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
    public List<Users> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public Optional<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        userService.updateUser(id, user);
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with id " + id + " deleted";
    }
}
