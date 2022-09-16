package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cn.felord.domain.externalcontact.MiniProgramStyle;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 11:14
 */
public enum SingleStyle implements MiniProgramStyle {
    SINGLE_STYLE_1(1),
    SINGLE_STYLE_2(2),
    SINGLE_STYLE_3(3);

    private final int style;

    SingleStyle(int style) {

        this.style = style;
    }

    @JsonValue
    @Override
    public int getStyle() {
        return style;
    }

    @JsonCreator
    public static SingleStyle deserialize(int style) {
        return Arrays.stream(SingleStyle.values())
                .filter(singleStyle -> singleStyle.style == style)
                .findFirst()
                .orElse(null);
    }
}
