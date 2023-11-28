package top.lamp.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookTypeDTO implements Serializable {
    private Integer id;

    private String typeName;
}
