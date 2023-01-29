package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserRegisterRequest extends UserRequest implements Serializable {

  /**
   * ユーザーID
   */
  @NotNull
  private Long id;

}