package top.lamp.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import top.lamp.api.UsersDubboService;
import top.lamp.model.UsersDO;
import top.lamp.result.Result;
import top.lamp.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    @DubboReference
    private UsersDubboService usersDubboService;

    @Override
    public Result login(UsersDO usersDO) {
        return usersDubboService.login(usersDO);
    }

    @Override
    public Result register(UsersDO usersDO) {
        return usersDubboService.register(usersDO);
    }
}
