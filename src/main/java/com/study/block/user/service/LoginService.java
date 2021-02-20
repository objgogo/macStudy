package com.study.block.user.service;

import com.study.block.user.entity.UserEntity;
import com.study.block.user.repository.UserRepository;
import com.study.block.user.vo.LoginUserRequest;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private UserRepository userRepository;

  public LoginService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean login(LoginUserRequest request){
    Optional<UserEntity> check = userRepository.findByUserIdAndPassword(request.getUserId(),
        request.getPassword());

    return check.isPresent();
  }
}
