package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class EnterSessionKfEvent extends KfEvent {

    private final String scene;
    private final String sceneParam;
    private final String welcomeCode;
    private final WechatChannels wechatChannels;

    @JsonCreator
    public EnterSessionKfEvent(@JsonProperty("open_kfid") String openKfid,
                               @JsonProperty("external_userid") String externalUserid,
                               @JsonProperty("scene") String scene,
                               @JsonProperty("scene_param") String sceneParam,
                               @JsonProperty("welcome_code") String welcomeCode,
                               @JsonProperty("wechat_channels") WechatChannels wechatChannels) {
        super(KfEventType.ENTER_SESSION, openKfid, externalUserid);
        this.scene = scene;
        this.sceneParam = sceneParam;
        this.welcomeCode = welcomeCode;
        this.wechatChannels = wechatChannels;
    }
}
