package cn.felord.domain.callcenter;

import lombok.Data;

/**
 * @author dax
 * @since 2021/8/23 14:19
 */
@Data
public class KfAccountUpdateRequest {
    private final String openKfid;
    private String name;
    private String mediaId;
}
