package com.study.block.user.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InsertUserRequest {

  @ApiModelProperty(value = "사용자 ID", example="jidpara")
  private String userId;
  @ApiModelProperty(value = "사용자 이름", example="홍길동")
  private String name;
  @ApiModelProperty(value = "사용자 이메일", example="abc@abc.com")
  private String email;
  @ApiModelProperty(value = "사용자 비밀번호", example="1q2w3e")
  private String password;


}
