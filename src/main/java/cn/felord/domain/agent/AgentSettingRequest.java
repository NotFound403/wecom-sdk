
package cn.felord.domain.agent;


import lombok.Data;

@Data
public class AgentSettingRequest {

    private Integer agentid;
    private String description;
    private String homeUrl;
    private Integer isreportenter;
    private String logoMediaid;
    private String name;
    private String redirectDomain;
    private Integer reportLocationFlag;

}
