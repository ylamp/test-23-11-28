package top.lamp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.lamp.result.Result;
import top.lamp.service.BookTypeService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/bookType/api")
public class BookTypeController {
    @Resource
    private BookTypeService bookTypeService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result getList() {
        return bookTypeService.getList();
    }
}
