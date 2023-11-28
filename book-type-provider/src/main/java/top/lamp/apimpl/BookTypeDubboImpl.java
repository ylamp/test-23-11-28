package top.lamp.apimpl;

import org.apache.dubbo.config.annotation.DubboService;
import top.lamp.api.BookTypeDubboService;
import top.lamp.dto.BookTypeDTO;
import top.lamp.mapper.BookTypeMapper;
import top.lamp.model.BookTypeDO;
import top.lamp.result.Result;
import top.lamp.result.ResultUtils;

import javax.annotation.Resource;
import java.util.List;

@DubboService
public class BookTypeDubboImpl implements BookTypeDubboService {
    @Resource
    private BookTypeMapper bookTypeMapper;

    @Override
    public Result getList() {
        List<BookTypeDO> typeDOList = bookTypeMapper.selectList(null);
        return ResultUtils.returnDataSuccess(typeDOList);
    }
}
