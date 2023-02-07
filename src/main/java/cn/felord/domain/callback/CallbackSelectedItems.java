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
public class CallbackSelectedItems {
    @XStreamImplicit(itemFieldName = "SelectedItem")
    private final List<CallbackSelectedItem> optionIds;

    public CallbackSelectedItems(CallbackSelectedItem... selectedItem) {
        this.optionIds = Arrays.asList(selectedItem);
    }
}
