package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/5/24 15:43
 */
@ToString
@Getter
public class TemplateId {
    private final String templateId;

    @JsonCreator
    public TemplateId(@JsonProperty("template_id") String templateId) {
        this.templateId = templateId;
    }
}
