package cn.felord.domain.externalcontact;

import cn.felord.enumeration.AddWays;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/8 18:26
 */
@Data
public class FollowUser  {
    private String userid;
    private String remark;
    private String description;
    private Instant createtime;
    private String remarkCorpName;
    private List<String> remarkMobiles;
    private WechatChannels wechatChannels;
    private String operUserid;
    private AddWays addWay;
    private String state;
    private List<ExternalContactTag> tags;
}
