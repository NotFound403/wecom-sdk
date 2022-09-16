package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/13 10:18
 */
@Data
public class CorpTagStrategyEditRequest {
    private final String id;
    private String name;
    private Integer order;
}
