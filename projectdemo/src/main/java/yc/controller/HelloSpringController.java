package yc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yc.service.UserService;
import yc.util.GenderEnum;
import yc.vo.UserVo;

@RestController
@RequestMapping("/hello")
public class HelloSpringController {


    @Autowired
    private UserService userService;

    @RequestMapping("/say")
    public ControllerResponse<UserVo> saySpring(){

        ControllerResponse response =  new ControllerResponse();
        response.setData(userService.getUserInfo(0L));
        System.out.println("print user info");
        return response;

    }



}
