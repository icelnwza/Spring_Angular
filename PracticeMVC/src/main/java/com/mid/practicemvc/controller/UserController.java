package com.mid.practicemvc.controller;

import com.mid.practicemvc.dto.UserDto;
import com.mid.practicemvc.entity.User;
import com.mid.practicemvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("add")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) throws Exception {
        User user = userService.addUser(userDto);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("distance")
    public ResponseEntity addDistance(@RequestParam String id,@RequestParam Double distance ) throws Exception{
        User user=userService.addDistanceFromId(id,distance);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("users")
    public ResponseEntity<List<UserDto>> showUsers(){
        List<UserDto> userDtoList = userService.showAll();
       return ResponseEntity.ok().body(userDtoList);
    }
}
