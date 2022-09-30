package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/9/23 14:36
 */
@Data
public class StatisticData {
    private Long newChatCnt;
    private Long chatTotal;
    private Long chatHasMsg;
    private Long newMemberCnt;
    private Long memberTotal;
    private Long memberHasMsg;
    private Long msgTotal;
    private Long migrateTraineeChatCnt;
}
