package cn.felord.domain.jssdk;

import cn.felord.domain.common.UserId;
import lombok.Getter;
import lombok.ToString;

/**
 * @author felord.cn
 * @since 1.0.0
 */
@ToString
@Getter
public class LaunchCodeRequest {
    /**
     * 当前操作者的userid
     */
    private final String operatorUserid;
    /**
     * 需要发起单聊对象的userid，仅支持企业内部成员
     */
    private final UserId singleChat;

    /**
     * Instantiates a new Launch code request.
     *
     * @param operatorUserid   the operator userid
     * @param singleChatUserId the single chat user id
     */
    public LaunchCodeRequest(String operatorUserid, String singleChatUserId) {
        this.operatorUserid = operatorUserid;
        this.singleChat = new UserId(singleChatUserId);
    }
}