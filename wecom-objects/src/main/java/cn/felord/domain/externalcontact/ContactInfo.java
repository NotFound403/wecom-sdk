package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * The type Contact info.
 *
 * @author dax
 * @since 2024/1/17
 */
@Data
public class ContactInfo {

    /**
     * 是否被成员标记为客户
     */
    private Boolean isCustomer;
    /**
     * 外部联系人临时ID，有效期为4小时。
     */
    private String tmpOpenid;
    /**
     * 脱敏后的外部联系人昵称（如果是其他外部联系人才返回）
     */
    private String name;
    /**
     * 添加此外部联系人的企业成员或外部联系人所在群聊的群主userid
     */
    private String followUserid;
    /**
     * 外部联系人所在的群聊ID（如果群聊被成员标记为客户群才返回）
     */
    private String chatId;
    /**
     * 外部联系人所在群聊的群名（如果群聊未被成员标记为客户群才返回）
     */
    private String chatName;
    /**
     * 外部联系人首次添加/进群的时间
     */
    private Instant addTime;
}
