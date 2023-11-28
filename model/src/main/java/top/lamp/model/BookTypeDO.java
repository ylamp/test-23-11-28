package top.lamp.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("book_type")
public class BookTypeDO implements Serializable {
    @TableId
    private Integer id;

    @TableField("type_name")
    private String typeName;
}
