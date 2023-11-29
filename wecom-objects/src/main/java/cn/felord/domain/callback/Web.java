package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2023/11/28
 */
@Data
public class Web {
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Url")
    private String url;
}
