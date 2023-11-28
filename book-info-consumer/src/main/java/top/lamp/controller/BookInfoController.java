package top.lamp.controller;


import org.springframework.web.bind.annotation.*;
import top.lamp.result.Result;
import top.lamp.service.BookInfoService;
import top.lamp.vo.QueryBookInfoVO;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/bookInfo/api")
public class BookInfoController {
    @Resource
    private BookInfoService bookInfoService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result getList(QueryBookInfoVO queryBookInfoVO) {
        return bookInfoService.getList(queryBookInfoVO);
    }

    @RequestMapping(value = "/borrow", method = RequestMethod.GET)
    public Result borrow(Integer bookId, Integer status) {
        return bookInfoService.borrow(bookId, status);
    }
}
