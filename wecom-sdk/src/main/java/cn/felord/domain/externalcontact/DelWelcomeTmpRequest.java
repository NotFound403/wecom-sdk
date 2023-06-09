package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2023/5/24 15:45
 */
@Data
public class DelWelcomeTmpRequest {
    private final String templateId;
    private final String agentid;
}
