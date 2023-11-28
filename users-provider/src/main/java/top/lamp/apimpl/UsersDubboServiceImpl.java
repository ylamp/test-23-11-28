package top.lamp.apimpl;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.apache.dubbo.config.annotation.DubboService;
import top.lamp.api.UsersDubboService;
import top.lamp.mapper.UsersMapper;
import top.lamp.model.UsersDO;
import top.lamp.result.Result;
import top.lamp.result.ResultUtils;

import javax.annotation.Resource;
import java.util.Date;

@DubboService
public class UsersDubboServiceImpl implements UsersDubboService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public Result login(UsersDO usersDO) {
        MPJLambdaWrapper<UsersDO> mpjLambdaWrapper = new MPJLambdaWrapper<>();
        mpjLambdaWrapper.eq(UsersDO::getUserCode, usersDO.getUserCode());
        UsersDO result = usersMapper.selectOne(mpjLambdaWrapper);
        if (null != result) {
            if (usersDO.getPassword().equals(result.getPassword())) {
                return ResultUtils.returnSuccess("登录成功", result);
            } else {
                return ResultUtils.returnFail("密码错误", "1001");
            }
        } else {
            return ResultUtils.returnFail("账号不存在", "1001");
        }
    }

    @Override
    public Result register(UsersDO usersDO) {
        usersDO.setRegisterTime(new Date());
        usersDO.setLastLogintime(new Date());
        int row = usersMapper.insert(usersDO);
        if (row > 0) {
            return ResultUtils.returnSuccess("注册成功");
        } else {
            return ResultUtils.returnFail("注册失败，请重试", "1001");
        }
    }
}
