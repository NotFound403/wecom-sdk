package cn.felord.domain.agent;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author felord.cn
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AgentDetailsResponse extends WeComResponse {
    private String agentid;
    private String name;
    private String squareLogoUrl;
    private String description;
    private AllowUsers allowUserinfos;
    private AllowParties allowPartys;
    private AllowTags allowTags;
    private Integer close;
    private String redirectDomain;
    private Integer reportLocationFlag;
    private Integer isreportenter;
    private String homeUrl;
    private Integer customizedPublishStatus;
}
