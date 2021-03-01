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

  //인증번호 6자리 생성
  public String createAuthString(){
    StringBuilder authString = new StringBuilder();
    char[] tmp = new char[6];
    for(int i=0; i<tmp.length; i++) {
      int div = (int) Math.floor( Math.random() * 2 );

      if(div == 0) { // 0이면 숫자로
        tmp[i] = (char) (Math.random() * 10 + '0') ;
      }else { //1이면 알파벳
        tmp[i] = (char) (Math.random() * 26 + 'A') ;
      }
      authString.append(tmp[i]);
    }


    return authString.toString();
  }
  //이름,인증번호

}
