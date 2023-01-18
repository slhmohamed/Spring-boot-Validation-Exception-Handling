package org.sid.validationexceptionhandling.controller;

import lombok.RequiredArgsConstructor;
import org.sid.validationexceptionhandling.dto.UserRequest;
import org.sid.validationexceptionhandling.entity.User;
import org.sid.validationexceptionhandling.exception.UserNotFoundException;
import org.sid.validationexceptionhandling.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> fetchAll(){
        return ResponseEntity.ok(userService.listUser());
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.singleUser(id));
    }
}
