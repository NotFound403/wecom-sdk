package cn.felord.domain.corpgroup;

import lombok.Data;

/**
 * @author dax
 * @since 2023/10/12
 */
@Data
public class CorpInfo {
    /**
     * 下级/下游企业corpid
     */
    private String corpid;
    /**
     * 下级/下游企业名称
     */
    private String corpName;
    /**
     * 下级/下游企业应用id
     */
    private String agentid;
}
