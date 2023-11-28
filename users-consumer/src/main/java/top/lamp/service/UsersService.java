package top.lamp.service;

import top.lamp.model.UsersDO;
import top.lamp.result.Result;

public interface UsersService {
    Result login(UsersDO usersDO);

    Result register(UsersDO usersDO);
}
