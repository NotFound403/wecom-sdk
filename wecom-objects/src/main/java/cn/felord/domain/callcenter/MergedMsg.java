package cn.felord.domain.callcenter;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/5
 */
@Data
public class MergedMsg {
    private String title;
    private List<MergedMsgItem> item;
}
