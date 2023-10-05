package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfMsgType;
import lombok.Data;

import java.time.Instant;

/**
 * 消息记录内的消息内容
 *
 * @author dax
 * @since 2023/10/5
 */
@Data
public class MergedMsgItem {
    /**
     * 发送时间
     */
    private Instant sendTime;
    /**
     * 消息类型
     */
    private KfMsgType msgtype;
    /**
     * 发送者名称
     */
    private String senderName;
    /**
     * 消息内容，Json字符串，结构可参考本文档消息类型说明
     */
    private String msgContent;
}