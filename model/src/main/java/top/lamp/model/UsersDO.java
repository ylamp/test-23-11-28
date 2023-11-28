package top.lamp.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("users")
public class UsersDO implements Serializable {
    @TableId
    private Integer userId;

    @TableField("user_code")
    private String userCode;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("gender")
    private String gender;

    @TableField("register_time")
    private Date registerTime;

    @TableField("last_logintime")
    private Date lastLogintime;
}
