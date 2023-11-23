package cn.felord.domain.living;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The LivingShareInfoResponse
 *
 * @author dax
 * @since 2023 /11/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LivingShareInfoResponse extends WeComResponse {
    /**
     * 直播id
     */
    private String livingid;
    /**
     * 观众的userid，观众为企业内部成员时返回
     */
    private String viewerUserid;
    /**
     * 观众的external_userid，观众为非企业内部成员时返回
     */
    private String viewerExternalUserid;
    /**
     * 邀请人的userid，邀请人为企业内部成员时返回（观众首次进入直播时，其使用的直播卡片/二维码所对应的分享人）
     */
    private String invitorUserid;
    /**
     * 邀请人的external_userid，邀请人为非企业内部成员时返回 （观众首次进入直播时，其使用的直播卡片/二维码所对应的分享人）
     */
    private String invitorExternalUserid;
}