package cn.felord.enumeration;

import cn.felord.convert.PayCallbackEventTypeConverter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Arrays;
import java.util.Objects;

/**
 * The PayCallbackEventType
 *
 * @author dax
 * @since 2023 /7/7 11:27
 */
@XStreamConverter(PayCallbackEventTypeConverter.class)
public enum PayCallbackEventType {
    /**
     * 支付成功通知
     */
    TRANSACTION_SUCCESS("TRANSACTION.SUCCESS"),
    /**
     * 退款成功通知
     */
    REFUND_SUCCESS("REFUND.SUCCESS"),
    /**
     * 退款异常通知
     */
    REFUND_ABNORMAL("REFUND.ABNORMAL"),
    /**
     * 退款关闭通知
     */
    REFUND_CLOSED("REFUND.CLOSED");

    private final String event;

    PayCallbackEventType(String event) {
        this.event = event;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return event;
    }


    /**
     * Deserialize PayCallbackEventType.
     *
     * @param event the event
     * @return the PayCallbackEventType
     */
    @JsonCreator
    public static PayCallbackEventType deserialize(String event) {
        return Arrays.stream(PayCallbackEventType.values())
                .filter(eventType -> Objects.equals(eventType.event, event))
                .findFirst()
                .orElse(null);
    }
}
