package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 应用工作台样式
 *
 * @author dax
 * @since 2023 /10/25
 */
public enum WorkbenchType {

    /**
     * 普通展示模式
     */
    NORMAL("normal"),
    /**
     * 关键数据型
     */
    KEY_DATA("keydata"),
    /**
     * 图片型
     */
    IMAGE("image"),
    /**
     * 列表型
     */
    LIST("list"),
    /**
     * webview型
     */
    WEBVIEW("webview");

    private final String type;

    WorkbenchType(String type) {
        this.type = type;
    }

    /**
     * Deserialize WorkbenchType
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static WorkbenchType deserialize(String type) {
        return Arrays.stream(WorkbenchType.values())
                .filter(workbenchType -> workbenchType.type.equals(type))
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }
}
