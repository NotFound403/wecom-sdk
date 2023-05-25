package cn.felord.domain.approval;

import cn.felord.enumeration.ApproverNodeMode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * @author dax
 * @since 2023/5/25
 */
@ToString
@Getter
public class Approver {
    private final ApproverNodeMode attr;
    private final List<String> userid;

    public Approver(String userid) {
        this.userid = Collections.singletonList(userid);
        this.attr = ApproverNodeMode.ALL;
    }

    public Approver(ApproverNodeMode attr, List<String> userid) {
        this.attr = attr;
        this.userid = userid;
    }
}
