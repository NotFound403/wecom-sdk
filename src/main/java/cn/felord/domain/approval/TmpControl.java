package cn.felord.domain.approval;

import cn.felord.json.TmpControlDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.ToString;

/**
 * 控件
 *
 * @author dax
 * @since 2023/5/25 14:42
 */
@ToString
@Getter
@JsonDeserialize(using = TmpControlDeserializer.class)
public class TmpControl<C> {
    private final CtrlProperty property;
    private final C config;

    @JsonCreator
    public TmpControl(@JsonProperty("property") CtrlProperty property, @JsonProperty("config") C config) {
        this.property = property;
        this.config = config;
    }
}
