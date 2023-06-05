package cn.felord.domain.callcenter;

import cn.felord.enumeration.MsgMenuContentType;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/3
 */
@ToString
@Getter
public class MiniprogramMsgMenuContent extends MsgMenuContent {
    private final Miniprogram miniprogram;
    public MiniprogramMsgMenuContent(Miniprogram miniprogram) {
        super(MsgMenuContentType.MINIPROGRAM);
        this.miniprogram = miniprogram;
    }

    @Data
    public static class Miniprogram {
        private String appid;
        private String pagepath;
        private String content;
    }
}
