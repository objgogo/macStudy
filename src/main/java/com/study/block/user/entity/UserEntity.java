package com.study.block.user.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@NoArgsConstructor(access =AccessLevel.PROTECTED)
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String userId;
  private String password;
  private String email;
  private String name;

  @Builder
  public UserEntity(Integer id, String userId, String password, String email, String name) {
    this.id = id;
    this.userId = userId;
    this.password = password;
    this.email = email;
    this.name = name;
  }
}
