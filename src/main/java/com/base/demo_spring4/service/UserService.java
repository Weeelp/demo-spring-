package com.base.demo_spring4.service;

import com.base.demo_spring4.repository.UserRepository;
import com.base.demo_spring4.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public List<User> saveUser(User user) {

    userRepository.save(user);
    List<User> userList = userRepository.findAll();
    return userList;
  }

  public List<User> findAllUsers() {
      return userRepository.findAll();
  }


  public User getUserJson(long id) {
    if (id == 777) {
      return new User(777, "иванов", "123qwe", "323233");
    } else {
      throw new IllegalArgumentException("invalid id = " + id);
    }
  }
}
