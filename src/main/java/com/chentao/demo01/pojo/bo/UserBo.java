package com.chentao.demo01.pojo.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "用户实体类")
@NotNull(message = "不能为空")
public class UserBo {


    @Schema(description = "用户唯一标识")
    
    private Long id;


    @Schema(description = "用户姓名")
    private String username;


    @Schema(description = "用户密码")
    private String password;
}