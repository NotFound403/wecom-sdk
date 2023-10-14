package cn.felord.domain.journal;

import cn.felord.domain.common.UserId;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
@Data
public class ReportUserRange {
    /**
     * 指定标签集合
     */
    private List<OpenTagId> tagList;
    /**
     * 指定部门集合
     */
    private List<OpenPartyId> partyList;
    /**
     * 指定人集合
     */
    private List<UserId> userList;
}