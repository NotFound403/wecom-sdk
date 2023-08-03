package cn.felord.domain.hr;

import cn.felord.enumeration.FieldType;
import lombok.Data;

@Data
public class FieldInfo {
    private Integer fieldid;
    private String fieldName;
    private FieldType fieldType;
    private Boolean isMust;
}