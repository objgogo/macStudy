package com.study.block.common;

import java.util.HashMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class BaseResponse {

  public static <T> T ok() {
    return BaseResponse.of(new ErrorVo(), MediaType.APPLICATION_JSON_VALUE, HttpStatus.OK);
  }

  public static <T> T ok(Object object) {
    return BaseResponse.of(object, MediaType.APPLICATION_JSON_VALUE, HttpStatus.OK);
  }

  public static <T> T of(Object object) {
    return BaseResponse.of(object, MediaType.APPLICATION_JSON_VALUE, HttpStatus.OK);
  }

  public static <T> T of(Object object, HttpStatus httpStatus) {
    return BaseResponse.of(object, MediaType.APPLICATION_JSON_VALUE, httpStatus);
  }

  @SuppressWarnings("unchecked")
  public static <T> T of(Object object, String mediaType, HttpStatus httpStatus) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", mediaType);
    return (T) new ResponseEntity<Object>(object, headers, httpStatus);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static <T> T error(ErrorVo errorVo) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    return BaseResponse.error(errorVo, headers, HttpStatus.OK);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static <T> T error(ErrorVo errorVo, HttpHeaders headers) {
    return BaseResponse.error(errorVo, headers, HttpStatus.OK);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static <T> T error(ErrorVo errorVo, HttpStatus status) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    return BaseResponse.error(errorVo, headers, status);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static <T> T error(ErrorVo errorVo, HttpHeaders headers, HttpStatus status) {
    HashMap<String, Object> error = new HashMap<String, Object>();
    HashMap<String, Object> item = new HashMap<String, Object>();
    item.put("code", errorVo.getCode());
    item.put("message",errorVo.getMessage());
    error.put("error", item);
    return (T) new ResponseEntity<HashMap>(error, headers, status);
  }

  @SuppressWarnings("unchecked")
  public static <T> T error(Object object) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    return (T) new ResponseEntity<Object>(object, headers, HttpStatus.OK);
  }
}
