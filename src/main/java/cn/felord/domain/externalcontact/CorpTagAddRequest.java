package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 19:51
 */
@Data
public class CorpTagAddRequest {
    private String groupId;
    private String groupName;
    private Long order;
    private List<CorpTagBase> tag;
    private String agentid;
}
