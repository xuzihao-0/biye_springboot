package com.bjpowernode.mp06.controller.user;

import com.bjpowernode.mp06.entity.CUser;
import com.bjpowernode.mp06.entity.User;
import com.bjpowernode.mp06.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/3/4 18:02
 */
@RestController
@Slf4j
public class UserController {

    @Autowired IUserService userService;



    @PostMapping("change_user")
    public int change(@RequestBody CUser user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode(user.getPassword());
        int  i =  userService.changeUser(user.getName(),encode1,user.getTelephone(),user.getUid()) ;
        return  i;
    }
    @GetMapping("testList")
    public List<Integer> test(){
        List<Integer> all = userService.findAll();
        return all;
    }



}
