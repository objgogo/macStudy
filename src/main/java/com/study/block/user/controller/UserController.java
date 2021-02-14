package com.study.block.user.controller;

import com.study.block.common.BaseResponse;
import com.study.block.user.entity.UserEntity;
import com.study.block.user.service.UserService;
import com.study.block.user.vo.InsertUserRequest;
import com.study.block.user.vo.InsertUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Api(tags = {
    "[사용자] - 사용자 조회 API"}, protocols = "http", produces = "application/json", consumes = "application/json")

public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/users")
  @ApiOperation(value = "모든 사용 조회 API", notes = "모든 user data 조회")
  public UserEntity searchUsers(){
    return userService.searchUsers();
  }

  @PostMapping("/users/{id}")
  @ApiOperation(value = "사용자 존재 유 조회 API", notes = "사용자 존재 유무 체")
  public boolean isUsers(@PathVariable(name = "id") Integer id){
    return userService.isUser(id);
  }

  @PostMapping("/users")
  @ApiOperation(value = "사용자 회원 가입 API", notes = "사용자 회원 가입")
  public InsertUserResponse insertUser(@RequestBody InsertUserRequest request){
    return userService.insertUser(request);
  }




}
