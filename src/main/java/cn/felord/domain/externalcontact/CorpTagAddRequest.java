package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 17:51
 */
@Data
public class CorpTagAddRequest {
    private String groupId;
    private String groupName;
    private Integer order;
    private Set<CorpTagBase> tag;
    private String agentid;
}
