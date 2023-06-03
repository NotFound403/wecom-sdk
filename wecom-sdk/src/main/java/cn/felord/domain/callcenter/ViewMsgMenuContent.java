package cn.felord.domain.callcenter;

import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * The type View msg menu content.
 *
 * @author dax
 * @since 2023 /6/3
 */
@ToString
@Getter
public class ViewMsgMenuContent extends MsgMenuContent {
    private final View view;

    /**
     * Instantiates a new View msg menu content.
     *
     * @param view the view
     */
    @JsonCreator
    public ViewMsgMenuContent(@JsonProperty("view") View view) {
        super(MsgMenuContentType.VIEW);
        this.view = view;
    }

    /**
     * The type View.
     */
    @Data
    public static class View {
        private String url;
        private String content;
    }
}
