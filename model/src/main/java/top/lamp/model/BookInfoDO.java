package top.lamp.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("book_info")
public class BookInfoDO implements Serializable {
    @TableId
    private Integer bookId;

    @TableField("book_code")
    private String bookCode;

    @TableField("book_name")
    private String bookName;

    @TableField("book_type")
    private Integer bookType;

    @TableField("book_author")
    private Integer bookAuthor;

    @TableField("publish_press")
    private String publishPress;

    @TableField("publish_data")
    private Date publishData;

    @TableField("is_borrow")
    private Integer isBorrow;

    @TableField("createdBy")
    private String createdBy;

    @TableField("create_time")
    private Date createTime;

    @TableField("last_updatetime")
    private Date lastUpdatetime;
}
