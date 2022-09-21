package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/10/20 13:46
 */
@Data
public class MomentInfoRequest {
    private final String momentId;
    private final String userid;
    private String cursor;
    private Integer limit;
}
