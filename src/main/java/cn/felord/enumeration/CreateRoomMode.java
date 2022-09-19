package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum CreateRoomMode {
    NONE(0),
    NEW(1);

    private final int type;

    CreateRoomMode(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static CreateRoomMode deserialize(int type) {
        return Arrays.stream(CreateRoomMode.values())
                .filter(contactScene -> contactScene.type == type)
                .findFirst()
                .orElse(null);
    }
}
