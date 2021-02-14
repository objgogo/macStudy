package com.study.block.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InsertUserResponse {

  @ApiModelProperty(value = "사용자 pk", example="1")
  private Integer id;

  @ApiModelProperty(value = "사용자 ID", example="jidpara")
  private String userId;

  @ApiModelProperty(value = "사용자 이름", example="홍길동")
  private String name;

  @ApiModelProperty(value = "사용자 Email", example="jidpara@abc.com")
  private String email;

  public InsertUserResponse(Integer id, String userId, String name, String email) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.email = email;
  }
}
