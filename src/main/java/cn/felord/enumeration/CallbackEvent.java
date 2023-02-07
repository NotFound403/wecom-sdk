package cn.felord.enumeration;

import cn.felord.callbacks.EventEnumConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * The enum Callback event enum.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
@XStreamConverter(EventEnumConverter.class)
public enum CallbackEvent {
    /**
     * 通讯录变更事件
     */
    CHANGE_CONTACT("change_contact"),
    /**
     * 客户变更事件
     */
    CHANGE_EXTERNAL_CONTACT("change_external_contact"),
    /**
     * 客户群变更事件
     */
    CHANGE_EXTERNAL_CHAT("change_external_chat"),
    /**
     * 企业客户标签变更事件
     */
    CHANGE_EXTERNAL_TAG("change_external_tag"),
    /**
     * <a href="https://developer.work.weixin.qq.com/document/path/90240#%E6%A8%A1%E6%9D%BF%E5%8D%A1%E7%89%87%E4%BA%8B%E4%BB%B6%E6%8E%A8%E9%80%81">模板卡片事件</a>
     */
    TEMPLATE_CARD_EVENT("template_card_event"),
    /**
     * 客服消息事件
     */
    KF_MSG("kf_msg_or_event");

    private final String type;

    CallbackEvent(String type) {
        this.type = type;
    }

    /**
     * Event string.
     *
     * @return the string
     */
    public String type() {
        return type;
    }
}
