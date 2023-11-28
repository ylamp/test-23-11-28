package top.lamp.api;

import top.lamp.result.Result;
import top.lamp.vo.QueryBookInfoVO;

public interface BookInfoDubboService {
    Result getList(QueryBookInfoVO queryBookInfoVO);

    Result borrow(Integer bookId, Integer status);
}
