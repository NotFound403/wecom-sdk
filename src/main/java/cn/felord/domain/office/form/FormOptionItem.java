package cn.felord.domain.office.form;

import cn.felord.enumeration.FormItemStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/3/13 16:52
 */
@ToString
@Getter
public class FormOptionItem {
    private final int key;
    private final String value;
    private final FormItemStatus status;

    @JsonCreator
    public FormOptionItem(@JsonProperty("key") int key, @JsonProperty("value") String value, @JsonProperty("status") FormItemStatus status) {
        this.key = key;
        this.value = value;
        this.status = status;
    }
}
