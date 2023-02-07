package cn.felord.domain.message;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2022/2/7 10:10
 */
@Data
public abstract class AbstractUpdateTemplateCardRequest {
    private Set<String> userids;
    private Set<Integer> partyids;
    private final String agentid;
    private final String responseCode;

}
