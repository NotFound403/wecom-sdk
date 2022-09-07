package cn.felord.domain.contactbook.linkedcorp;

import lombok.Data;

import java.util.List;

/**
 * @author felord.cn
 * @since 2022/9/7 11:26
 */
@Data
public class CorpSimpleUserInfo {
    private String userid;
    private String name;
    private List<String> department;
    private String corpid;
}
