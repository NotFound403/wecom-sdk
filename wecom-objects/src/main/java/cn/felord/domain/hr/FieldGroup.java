package cn.felord.domain.hr;

import lombok.Data;

import java.util.List;

@Data
public class FieldGroup {
    private Integer groupId;
    private String groupName;
    private List<FieldInfo> fieldList;
}