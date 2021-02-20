package com.study.block.user.service;

import com.study.block.user.entity.UserEntity;
import com.study.block.user.repository.UserRepository;
import com.study.block.user.vo.InsertUserRequest;
import com.study.block.user.vo.InsertUserResponse;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserEntity searchUsers() {
    Optional<UserEntity> tmp = userRepository.findById(1);
    return tmp.get();
  }

  public boolean isUserId(String userId) {
    Optional<UserEntity> check = userRepository.findByUserId(userId);
    return check.isPresent();

  }


  public InsertUserResponse insertUser(InsertUserRequest request) {
    UserEntity user = userRepository.save(
        UserEntity.builder()
            .userId(request.getUserId())
            .email(request.getEmail())
            .name(request.getName())
            .password(request.getPassword())
            .build());

    InsertUserResponse res =
        new InsertUserResponse(
            user.getId(),
            user.getUserId(),
            user.getName(),
            user.getEmail());

    return res;

  }

}
