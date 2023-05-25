package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 审批模板控件类型
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum ContactCtrlMode {

    /**
     * 部门
     */
    DEPARTMENT("department"),
    /**
     * 成员
     */
    USER("user");

    private final String mode;

    ContactCtrlMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getMode() {
        return mode;
    }


    /**
     * Deserialize approval ctrl mode.
     *
     * @param mode the mode
     * @return the approval ctrl mode
     */
    @JsonCreator
    public static ContactCtrlMode deserialize(String mode) {
        return Arrays.stream(ContactCtrlMode.values())
                .filter(contactType -> contactType.mode.equals(mode))
                .findFirst()
                .orElse(null);
    }
}
