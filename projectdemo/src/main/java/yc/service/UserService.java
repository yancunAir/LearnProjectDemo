package yc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yc.util.GenderEnum;
import yc.vo.UserVo;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {


    public UserVo getUserInfo(Long userId){
        UserVo userVo = new UserVo();
        userVo.setId(0L);
        userVo.setAge(27);
        userVo.setUserName("yancun");
        userVo.setEmail("838522542@qq.com");
        userVo.setGender(GenderEnum.MAN.getText());
        userVo.setPassword("123456");
        return userVo;

    }



}
