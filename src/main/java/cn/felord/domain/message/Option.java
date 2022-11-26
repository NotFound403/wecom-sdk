package cn.felord.domain.message;

import lombok.Data;

/**
 * @author dax
 * @since 2022/11/25
 */
@Data
public class Option {
    private final String id;
    private final String text;
    private final Boolean isChecked;


    public Option(String id, String text) {
        this(id,text,null);
    }

    public Option(String id, String text, Boolean isChecked) {
        this.id = id;
        this.text = text;
        this.isChecked = isChecked;
    }
}
