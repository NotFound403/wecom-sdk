package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2023/5/27
 */
@Data
public class CallbackUserId {
    @XStreamAlias("UserId")
    private String userId;
}
