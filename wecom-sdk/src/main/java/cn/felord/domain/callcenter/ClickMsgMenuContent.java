package cn.felord.domain.callcenter;

import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Click msg menu content.
 *
 * @author dax
 * @since 2023 /6/3
 */
@ToString
@Getter
public class ClickMsgMenuContent extends MsgMenuContent {
    private final Click click;

    /**
     * Instantiates a new Click msg menu content.
     *
     * @param click the click
     */
    @JsonCreator
    public ClickMsgMenuContent(@JsonProperty("click") Click click) {
        super(MsgMenuContentType.CLICK);
        this.click = click;
    }

    /**
     * The type Click.
     */
    @Data
    public static class Click{
        private String id;
        private String content;
    }
}
