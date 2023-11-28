package top.lamp.service.controller;


import org.springframework.web.bind.annotation.*;
import top.lamp.model.UsersDO;
import top.lamp.result.Result;
import top.lamp.service.UsersService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/users/api")
public class UsersController {
    @Resource
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody UsersDO usersDO) {
        System.out.println(usersDO);
        return usersService.login(usersDO);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody UsersDO usersDO) {
        return usersService.register(usersDO);
    }
}
