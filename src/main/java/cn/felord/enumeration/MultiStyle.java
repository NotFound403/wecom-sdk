package cn.felord.enumeration;

import cn.felord.domain.externalcontact.MiniProgramStyle;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 11:14
 */
public enum MultiStyle implements MiniProgramStyle {
    MULTI_STYLE_1(1),
    MULTI_STYLE_2(2);

    private final int style;

    MultiStyle(int style) {

        this.style = style;
    }

    @JsonValue
    @Override
    public int getStyle() {
        return style;
    }

    @JsonCreator
    public static MultiStyle deserialize(int style) {
        return Arrays.stream(MultiStyle.values())
                .filter(multiStyle -> multiStyle.style == style)
                .findFirst()
                .orElse(null);
    }
}
