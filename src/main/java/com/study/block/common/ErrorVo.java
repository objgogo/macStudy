package com.study.block.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
public class ErrorVo {

  public final static String SUCCESS = "00";

  @ApiModelProperty(value = "성공/에러코드", example="00")
  private String code = SUCCESS;

  @ApiModelProperty(value = "에러의 경우 에러메시지", example="")
  private String message = "";

  public ErrorVo() {
  }

  public ErrorVo(String code) {
    super();
    this.code    = code;
    this.message = "";
  }

  public ErrorVo(String code, String message) {
    super();
    this.code    = code;
    this.message = message;
  }

  public String toJson() {
    String json = "";
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      json = objectMapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      log.error(e.getMessage(), e);
    }

    return json;
  }
}
