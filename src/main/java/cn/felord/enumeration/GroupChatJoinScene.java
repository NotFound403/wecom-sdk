package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum GroupChatJoinScene {
    DIRECT_BY_MEMBER(1),
    LINK_BY_MEMBER(2),
    QR_CODE(3);

    private final int type;

    GroupChatJoinScene(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static GroupChatJoinScene deserialize(int type) {
        return Arrays.stream(GroupChatJoinScene.values())
                .filter(contactScene -> contactScene.type == type)
                .findFirst()
                .orElse(null);
    }
}
