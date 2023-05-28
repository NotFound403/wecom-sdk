package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 回调对象
 *
 * @author felord
 * @since 2021/10/12 21:23
 */
@Data
public class Applyer {
    @XStreamAlias("UserId")
    private String userId;
    @XStreamAlias("Party")
    private String party;
}