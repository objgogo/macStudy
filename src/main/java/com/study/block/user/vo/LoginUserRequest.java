package com.study.block.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginUserRequest {

  @ApiModelProperty(value = "사용자 아이디", example="abcd")
  private String userId;

  @ApiModelProperty(value = "사용자 비밀번호", example="1234")
  private String password;

}
