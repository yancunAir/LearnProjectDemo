package yc.vo;

import lombok.Data;
import yc.util.GenderEnum;

@Data
public class UserVo {


    private String userName;

    private Integer age;

    private String email;

    private String gender;

    private String password;



}
