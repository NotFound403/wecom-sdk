package cn.felord.domain.callcenter;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/3
 */
@Data
public class KfMsgMenu {
    private String headContent;
    private List<MsgMenuContent> list;
    private String tailContent;
}
