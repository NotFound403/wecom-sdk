package cn.felord.domain.corpay.external;

import lombok.Data;

/**
 * @author xiafang
 * @since 2023/6/29 14:04
 */
@Data
public class MchScopeRequest {
    private final String mchId;
    private final MchScope allowUseScope;
}
