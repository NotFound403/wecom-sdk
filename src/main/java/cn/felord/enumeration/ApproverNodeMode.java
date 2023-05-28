package cn.felord.enumeration;

import cn.felord.callbacks.CallbackNumberEnum;
import cn.felord.callbacks.NumberEnumConverter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
@XStreamConverter(NumberEnumConverter.class)
public enum ApproverNodeMode implements CallbackNumberEnum {
    OR(1),
    ALL(2);

    private final int mode;

    ApproverNodeMode(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getType() {
        return mode;
    }

    @JsonCreator
    public static ApproverNodeMode deserialize(int mode) {
        return Arrays.stream(ApproverNodeMode.values())
                .filter(contactType -> contactType.mode == mode)
                .findFirst()
                .orElse(null);
    }

}
