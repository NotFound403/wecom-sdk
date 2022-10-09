package cn.felord.domain.callcenter;

import cn.felord.enumeration.VoiceFormat;
import lombok.Data;

/**
 * @author dax
 * @since 2021/12/8 17:00
 */
@Data
public class SyncMsgRequest {
    private String cursor;
    private String token;
    private Integer limit;
    private VoiceFormat voiceFormat;
}
