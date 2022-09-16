package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum ContactScene {
    MINI_PROGRAM(1),
    QR_CODE(2);

    private final int type;

    ContactScene(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static ContactScene deserialize(int type) {
        return Arrays.stream(ContactScene.values())
                .filter(contactScene -> contactScene.type == type)
                .findFirst()
                .orElse(null);
    }
}
