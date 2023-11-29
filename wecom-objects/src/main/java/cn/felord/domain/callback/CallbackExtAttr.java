package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/11/29
 */
@Data
public class CallbackExtAttr {
    @XStreamImplicit(itemFieldName = "Item")
    private List<CallbackExtAttrItem> items;
}
