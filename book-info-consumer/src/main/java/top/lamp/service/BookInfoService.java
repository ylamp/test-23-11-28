package top.lamp.service;

import top.lamp.result.Result;
import top.lamp.vo.QueryBookInfoVO;

public interface BookInfoService {
    Result getList(QueryBookInfoVO queryBookInfoVO);

    Result borrow(Integer bookId, Integer status);
}
