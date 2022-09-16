package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/13 11:35
 */
@Data
public abstract class CorpTagOptRequest {
    private final String userid;
    private final String externalUserid;
}
