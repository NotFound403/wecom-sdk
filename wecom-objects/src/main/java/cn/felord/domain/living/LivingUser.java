package cn.felord.domain.living;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.time.Duration;

/**
 * @author dax
 * @since 2023/5/24 11:36
 */
@Data
public class LivingUser {

    /**
     * 企业成员的userid
     */
    private String userid;
    /**
     * 观看时长，单位为秒
     */
    private Duration watchTime;
    /**
     * 是否评论
     */
    private BoolEnum isComment;
    /**
     * 是否连麦发言
     */
    private Integer isMic;
    /**
     * 邀请人的userid
     */
    private String invitorUserid;
    /**
     * 邀请人的external_userid
     */
    private String invitorExternalUserid;
}