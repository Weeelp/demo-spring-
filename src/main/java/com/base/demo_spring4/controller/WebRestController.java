package com.base.demo_spring4.controller;

import com.base.demo_spring4.model.User;
import com.base.demo_spring4.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class WebRestController {
  private static Logger logger = LoggerFactory.getLogger(WebRestController.class);
  private final UserService userService;
  public WebRestController(UserService userService) {
    this.userService = userService;
  }
  @GetMapping("/{userId:\\d+}")
  public ResponseEntity<User> getUserJson(@PathVariable long userId) {
    return new ResponseEntity<>(userService.getUserJson(userId), HttpStatus.OK);
  }
  @PostMapping("/user")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    // service add
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }
}
