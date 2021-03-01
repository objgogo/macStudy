package com.study.block.user.controller;


import com.study.block.user.service.LoginService;
import com.study.block.user.vo.LoginUserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Api(tags = {
    "[사용자] - 로그인 API"}, protocols = "http", produces = "application/json", consumes = "application/json")
public class LoginController {

  private LoginService loginService;

  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping("/login")
  @ApiOperation(value = "로그인 API", notes = "로그인 API")
  public boolean login(@RequestBody LoginUserRequest request){
    return loginService.login(request);
  }

  @PostMapping("/create/auth-string")
  @ApiOperation(value = "인증 문자열 생성(6자리) API", notes = "랜덤 문자열 생성 API")
  public String createAuthString(){
    return loginService.createAuthString();
  }





}
