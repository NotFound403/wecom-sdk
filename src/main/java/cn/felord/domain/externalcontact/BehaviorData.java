package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/9/23 14:17
 */
@Data
public class BehaviorData {

    private Instant statTime;
    private Long newApplyCnt;
    private Long newContactCnt;
    private Long chatCnt;
    private Long messageCnt;
    private Long avgReplyTime;
    private Double replyPercentage;
    private Long negativeFeedbackCnt;

}
