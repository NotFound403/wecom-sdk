package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2022/2/7 14:55
 */
@XStreamAlias("Item")
@Data
public class CallbackExtAttrItem {
    @XStreamAlias("Type")
    private Integer type;
    @XStreamAlias("Name")
    private String name;
    @XStreamAlias("Web")
    private Web web;
    @XStreamAlias("Text")
    private Text text;

    @Data
    public static class Web {
        @XStreamAlias("Title")
        private String title;
        @XStreamAlias("Url")
        private String url;
    }

    @Data
    public static class Text {
        @XStreamAlias("Value")
        private String value;
    }
}
