package bkit.training.SpringBootDemo.controller;

import bkit.training.SpringBootDemo.exception.InvalidConstrainException;
import bkit.training.SpringBootDemo.model.UserEntity;
import bkit.training.SpringBootDemo.request.NewUserRequest;
import bkit.training.SpringBootDemo.response.ListUserResponse;
import bkit.training.SpringBootDemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService){
    this.userService=userService;
  }

  @GetMapping("find-all")
  public ListUserResponse findAll(){
    return userService.findAll();
  }

  @PostMapping("create")
  public UserEntity create(@RequestBody NewUserRequest request) throws InvalidConstrainException {
    return userService.create(request);
  }

  @GetMapping("findByLastname/{key}")
  public ListUserResponse findByLastname(@PathVariable("key")String key){
    return userService.findByLastname(key);
  }

  @GetMapping("findByFirstnameAndLastname/{key}")
  public ListUserResponse findByFirstnameAndLastname(@PathVariable("key")String key){
    return userService.findByFirstnameAndLastname(key);
  }
}
