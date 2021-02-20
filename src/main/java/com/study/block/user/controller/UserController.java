package com.study.block.user.controller;

import com.study.block.user.entity.UserEntity;
import com.study.block.user.service.UserService;
import com.study.block.user.vo.InsertUserRequest;
import com.study.block.user.vo.InsertUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Api(tags = {
    "[사용자] - 사용자 조회 API"}, protocols = "http", produces = "application/json", consumes = "application/json")

public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  @ApiOperation(value = "테스 API", notes = "테스트 data 조회")
  public UserEntity searchUsers() {
    return userService.searchUsers();
  }

  @PostMapping("/users/check")
  @ApiOperation(value = "사용자 ID 중복 여부 조회 API", notes = "사용자 ID 중복 여부 조회")
  public boolean isUsers(@RequestParam(name = "userId") String userId) {
    return userService.isUserId(userId);
  }

  @PostMapping("/users")
  @ApiOperation(value = "사용자 회원 가입 API", notes = "사용자 회원 가입")
  public InsertUserResponse insertUser(@RequestBody InsertUserRequest request) {
    return userService.insertUser(request);
  }




}
