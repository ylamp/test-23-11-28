package top.lamp.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryBookInfoVO implements Serializable {
    private Integer bookType;
    private String bookName;
    private Integer isBorrow;
    private Integer currentPage;
}
