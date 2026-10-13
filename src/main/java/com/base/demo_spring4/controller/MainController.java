package com.base.demo_spring4.controller;

import com.base.demo_spring4.model.User;
import com.base.demo_spring4.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class MainController {
  private static Logger logger = LoggerFactory.getLogger(MainController.class);
  private final UserService userService;

  public MainController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public String indexAction(){
    logger.info("----first info log");
    return "index";
  }
  @PostMapping("/multi")
  public String multiplyAction(@RequestParam("num") int number, Model model) {
    int resNum = number * 3;
    //int resNum = Integer.parseInt( number) * 3;
    model.addAttribute("res_num", resNum);
    return "add_new_user";
  }
  @PostMapping("/add_user")
  public String addUserAction(HttpServletRequest request,
                              @RequestParam("firstname")String firstname,
                              @RequestParam("password")String pass,
                              @RequestParam("phone") String phoneNum,
                              @RequestParam("role") String role,
                              Model model) {
    User user = new User(firstname, pass, phoneNum, role);
    request.getSession().setAttribute("role", role);
    List<User> usersAll = userService.saveUser(user);
    model.addAttribute("users_all", usersAll);
    request.setAttribute("attr", "Hello Request");
    return "redirect:/users";
  }
  @ExceptionHandler(Exception.class)
 // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleException(Exception ex, Model model) {
    model.addAttribute("exception", ex);
    return "error";
  }

  @GetMapping("/users")
  public String showUsersList(Model model) {
      List<User> usersAll = userService.findAllUsers();
      model.addAttribute("users_all", usersAll);

      return "users";
  }

 // @GetMapping("/error_404")
 // public String handleNotFound() {
 //   throw new RuntimeException("NOT FOUND");
 // }

}
