package cn.felord.domain.callback;

import cn.felord.enumeration.SpStatus;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.time.Instant;

/**
 * The type Details.
 *
 * @author dax
 * @since 2023 /5/27
 */
@Data
public class Details {
    @XStreamAlias("Approver")
    private CallbackUserId approver;
    @XStreamAlias("SpStatus")
    private SpStatus spStatus;
    @XStreamAlias("SpTime")
    private Instant spTime;
}

