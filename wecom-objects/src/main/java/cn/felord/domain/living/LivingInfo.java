package cn.felord.domain.living;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.LivingReplayStatus;
import cn.felord.enumeration.LivingStatus;
import cn.felord.enumeration.LivingType;
import lombok.Data;

import java.time.Duration;
import java.time.Instant;

/**
 * The LivingInfo
 *
 * @author dax
 * @since 2023 /11/23
 */
@Data
public class LivingInfo {

    /**
     * 直播主题
     */
    private String theme;
    /**
     * 直播开始时间戳
     */
    private Instant livingStart;
    /**
     * 直播时长，单位为秒
     */
    private Duration livingDuration;
    /**
     * 直播的状态
     */
    private LivingStatus status;
    /**
     * 直播预约的开始时间戳
     */
    private Instant reserveStart;
    /**
     * 直播预约时长，单位为秒
     */
    private Duration reserveLivingDuration;
    /**
     * 直播的描述，最多支持100个汉字
     */
    private String description;
    /**
     * 主播的userid
     */
    private String anchorUserid;
    /**
     * 主播所在主部门id
     */
    private Integer mainDepartment;
    /**
     * 观看直播总人数
     */
    private Integer viewerNum;
    /**
     * 评论数
     */
    private Integer commentNum;
    /**
     * 连麦发言人数
     */
    private Integer micNum;
    /**
     * 是否开启回放
     */
    private BoolEnum openReplay;
    /**
     * open_replay为1时才返回该字段。0表示生成成功，1表示生成中，2表示回放已删除，3表示生成失败
     */
    private LivingReplayStatus replayStatus;
    /**
     * 直播的类型
     */
    private LivingType type;
    /**
     * 推流地址，仅直播类型为活动直播并且直播状态是待开播返回该字段
     */
    private String pushStreamUrl;
    /**
     * 当前在线观看人数
     */
    private Integer onlineCount;
    /**
     * 直播预约人数
     */
    private Integer subscribeCount;
}