package cn.felord.domain.callcenter;

import lombok.Data;

/**
 * @author xiafang
 * @since 2022/9/26 14:19
 */
@Data
public class KfAccountUpdateRequest {
    private final String openKfid;
    private String name;
    private String mediaId;
}
