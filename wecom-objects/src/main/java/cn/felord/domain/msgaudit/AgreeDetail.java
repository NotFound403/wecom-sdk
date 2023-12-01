package cn.felord.domain.msgaudit;

import cn.felord.enumeration.AgreeStatus;
import lombok.Data;

import java.time.Instant;

/**
 * The type AgreeDetail
 *
 * @author dax
 * @since 2023 /12/1
 */
@Data
public class AgreeDetail {
    /**
     * 同意状态改变的具体时间
     */
    private Instant statusChangeTime;
    /**
     * 同意会话存档的状态
     */
    private AgreeStatus agreeStatus;
    /**
     * 员工
     */
    private String userid;
    /**
     * 外部联系人
     */
    private String exteranalopenid;
}