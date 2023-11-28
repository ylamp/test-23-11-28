package top.lamp.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import top.lamp.api.BookTypeDubboService;
import top.lamp.result.Result;
import top.lamp.service.BookTypeService;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @DubboReference
    private BookTypeDubboService bookTypeDubboService;

    @Override
    public Result getList() {
        return bookTypeDubboService.getList();
    }
}
