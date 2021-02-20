package com.study.block.user.repository;

import com.study.block.user.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

  Optional<UserEntity> findByUserId(String userId);
  Optional<UserEntity> findByUserIdAndPassword(String userId,String password);

}
