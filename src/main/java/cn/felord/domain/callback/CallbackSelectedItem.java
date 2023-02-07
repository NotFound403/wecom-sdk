package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * @author dax
 * @since 2022/2/7 15:00
 */
@ToString
@Data
public class CallbackSelectedItem {
    @XStreamAlias("QuestionKey")
    private String questionKey;
    @XStreamAlias(value = "OptionIds")
    private CallbackOptionIds optionIds;
}
