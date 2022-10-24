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
    CHANGE_EXTERNAL_TAG("change_external_tag");

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
