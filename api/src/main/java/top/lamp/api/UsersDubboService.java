package top.lamp.api;

import top.lamp.model.UsersDO;
import top.lamp.result.Result;

public interface UsersDubboService {
    Result login(UsersDO usersDO);

    Result register(UsersDO usersDO);
}
