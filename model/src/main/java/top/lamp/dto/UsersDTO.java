package top.lamp.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UsersDTO implements Serializable {
    private Integer userId;
    private String userCode;
    private String password;
    private String email;
    private String gender;
    private Date registerTime;
    private Date lastLogintime;
}
