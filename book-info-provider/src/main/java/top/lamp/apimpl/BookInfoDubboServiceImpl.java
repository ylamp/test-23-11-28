package top.lamp.apimpl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.apache.dubbo.config.annotation.DubboService;
import top.lamp.api.BookInfoDubboService;
import top.lamp.dto.BookInfoDTO;
import top.lamp.mapper.BookInfoMapper;
import top.lamp.model.BookInfoDO;
import top.lamp.model.BookTypeDO;
import top.lamp.model.UsersDO;
import top.lamp.result.Result;
import top.lamp.result.ResultUtils;
import top.lamp.vo.QueryBookInfoVO;

import javax.annotation.Resource;

@DubboService
public class BookInfoDubboServiceImpl implements BookInfoDubboService {
    @Resource
    private BookInfoMapper bookInfoMapper;

    @Override
    public Result getList(QueryBookInfoVO queryBookInfoVO) {
        MPJLambdaWrapper<BookInfoDO> mpjLambdaWrapper = new MPJLambdaWrapper<>();
        if (queryBookInfoVO.getBookType() != null && queryBookInfoVO.getBookType() != 0) {
            mpjLambdaWrapper.eq(BookInfoDO::getBookType, queryBookInfoVO.getBookType());
        }
        if (queryBookInfoVO.getBookName() != null && !queryBookInfoVO.getBookName().equals("")) {
            mpjLambdaWrapper.like(BookInfoDO::getBookName, queryBookInfoVO.getBookName());
        }
        if (queryBookInfoVO.getIsBorrow() != null && queryBookInfoVO.getIsBorrow() != -1) {
            mpjLambdaWrapper.eq(BookInfoDO::getIsBorrow, queryBookInfoVO.getIsBorrow());
        }
        mpjLambdaWrapper.select("book_code", "type_name", "book_name", "user_code", "publish_press", "is_borrow","book_id");
        mpjLambdaWrapper.innerJoin("book_type on book_type.id = t.book_type");
        mpjLambdaWrapper.innerJoin("users on users.user_id = t.book_author");
//        mpjLambdaWrapper.innerJoin(BookTypeDO.class, BookTypeDO::getId, BookInfoDO::getBookType);
//        mpjLambdaWrapper.innerJoin(UsersDO.class, UsersDO::getUserId, BookInfoDO::getBookAuthor);
        IPage<BookInfoDTO> iPage = Page.of(queryBookInfoVO.getCurrentPage(), 5);
        IPage<BookInfoDTO> result = bookInfoMapper.selectJoinPage(iPage, BookInfoDTO.class, mpjLambdaWrapper);
        return ResultUtils.returnDataSuccess(result);
    }

    @Override
    public Result borrow(Integer bookId, Integer status) {
        LambdaUpdateWrapper<BookInfoDO> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(BookInfoDO::getBookId, bookId);
        BookInfoDO bookInfoDO = new BookInfoDO();
        bookInfoDO.setIsBorrow(status);
        int row = bookInfoMapper.update(bookInfoDO, lambdaUpdateWrapper);
        return row == 1 ? ResultUtils.returnSuccess() : ResultUtils.returnFail();
    }
}
