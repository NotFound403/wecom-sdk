package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * @author dax
 * @since 2022/2/7 14:57
 */
@ToString
@Getter
public class CallbackOptionIds {
    @XStreamImplicit(itemFieldName = "OptionId")
    private final List<String> optionIds;

    public CallbackOptionIds(String... optionId) {
        this.optionIds = Arrays.asList(optionId);
    }
}
