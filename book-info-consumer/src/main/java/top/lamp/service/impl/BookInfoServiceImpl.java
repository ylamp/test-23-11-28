package top.lamp.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import top.lamp.api.BookInfoDubboService;
import top.lamp.result.Result;
import top.lamp.service.BookInfoService;
import top.lamp.vo.QueryBookInfoVO;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @DubboReference
    private BookInfoDubboService bookInfoDubboService;

    @Override
    public Result getList(QueryBookInfoVO queryBookInfoVO) {
        return bookInfoDubboService.getList(queryBookInfoVO);
    }

    @Override
    public Result borrow(Integer bookId, Integer status) {
        return bookInfoDubboService.borrow(bookId, status);
    }
}
