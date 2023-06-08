package cn.felord.domain.callcenter;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/6
 */
@Data
public class KFMemberRange {
    private List<String> useridList;
    private List<Long> departmentIdList;
}