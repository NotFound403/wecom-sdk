package cn.felord.mp.domain.message;

import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/8/24
 */
@ToString
@Getter
public class TemplateValue {
    private final String value;

    public TemplateValue(String value) {
        this.value = value;
    }
}
