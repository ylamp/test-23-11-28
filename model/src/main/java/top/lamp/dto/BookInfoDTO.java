package top.lamp.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BookInfoDTO implements Serializable {
    private Integer bookCode;
    private String typeName;
    private String bookName;
    private String userCode;
    private String publishPress;
    private Integer isBorrow;
    private Integer bookId;
}
