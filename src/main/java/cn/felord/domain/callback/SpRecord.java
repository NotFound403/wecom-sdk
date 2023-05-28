package cn.felord.domain.callback;

import cn.felord.enumeration.ApproverNodeMode;
import cn.felord.enumeration.SpStatus;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/27
 */
@Data
public class SpRecord {
    @XStreamAlias("SpStatus")
    private SpStatus spStatus;
    @XStreamAlias("ApproverAttr")
    private ApproverNodeMode approverAttr;
    @XStreamImplicit(itemFieldName = "Details")
    private List<Details> details;
}

