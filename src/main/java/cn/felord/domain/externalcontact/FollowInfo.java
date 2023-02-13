package cn.felord.domain.externalcontact;

import cn.felord.enumeration.AddWays;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/9 11:03
 */
@Data
public class FollowInfo  {
    private String userid;
    private String remark;
    private String description;
    private Instant createtime;
    private List<String> tagId;
    private String remarkCorpName;
    private List<String> remarkMobiles;
    private WechatChannels wechatChannels;
    private String operUserid;
    private String state;
    private AddWays addWay;
}
