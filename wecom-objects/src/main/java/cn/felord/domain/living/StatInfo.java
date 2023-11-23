package cn.felord.domain.living;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/24 11:36
 */
@Data
public class StatInfo {

    /**
     * 观看直播的企业成员列表
     */
    private List<LivingUser> users;
    /**
     * 观看直播的外部成员列表
     */
    private List<LivingExternalUser> externalUsers;

}