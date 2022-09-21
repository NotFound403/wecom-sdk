package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/10/19 18:13
 */
@Data
public class MomentTaskRequest {
    private final String momentId;
    private String cursor;
    private Integer limit;
}
