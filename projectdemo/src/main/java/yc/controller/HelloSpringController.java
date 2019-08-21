package yc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yc.util.GenderEnum;
import yc.vo.UserVo;

@RestController
@RequestMapping("/hello")
public class HelloSpringController {


    @RequestMapping("/say")
    public ControllerResponse<UserVo> saySpring(){

        ControllerResponse response =  new ControllerResponse();
        UserVo userVo = new UserVo();
        userVo.setAge(27);
        userVo.setUserName("yancun");
        userVo.setEmail("838522542@qq.com");
        userVo.setGender(GenderEnum.MAN.getText());
        userVo.setPassword("123456");
        response.setData(userVo);

        return response;

    }



}
