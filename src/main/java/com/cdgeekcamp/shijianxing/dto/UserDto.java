package com.cdgeekcamp.shijianxing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "请输入有效的姓名")
    private String name;

    @NotEmpty(message = "请输入有效的电子邮箱")
    @Email
    private String email;

    @NotEmpty(message = "请输入有效的用户密码")
    private String password;
}
