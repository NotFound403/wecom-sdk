package cn.felord.domain.message;

import cn.felord.enumeration.ButtonStyle;
import cn.felord.enumeration.ButtonType;
import lombok.Data;

/**
 * @author felord
 * @since 2021/11/23 16:15
 */
@Data
public class Button {
    private final ButtonType type;
    private final String text;
    private final ButtonStyle style;
    private final String key;
    private final String url;
}
