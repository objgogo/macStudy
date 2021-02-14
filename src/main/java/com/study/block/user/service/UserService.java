package com.study.block.user.service;

import com.study.block.user.entity.UserEntity;
import com.study.block.user.repository.UserRepository;
import com.study.block.user.vo.InsertUserRequest;
import com.study.block.user.vo.InsertUserResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public UserEntity searchUsers(){
    Optional<UserEntity> tmp = userRepository.findById(1);
    return tmp.get();
  }

  public boolean isUser(Integer id){
    Optional<UserEntity> check = userRepository.findById(id);
    return check.isPresent();
  }


  public InsertUserResponse insertUser(InsertUserRequest request){
    UserEntity user = userRepository.save(UserEntity.builder()
        .userId(request.getUserId())
        .email(request.getEmail())
        .name(request.getName())
        .password(request.getPassword())
    .build());

    InsertUserResponse res = new InsertUserResponse(user.getId(),user.getUserId(),user.getName(),user.getEmail());
    return res;

  }

}
