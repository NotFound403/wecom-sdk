package cn.felord.domain.contactbook.linkedcorp;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/7 11:26
 */
@Data
public class CorpSimpleUserInfo {
    private String userid;
    private String name;
    private List<String> department;
    private String corpid;
}
