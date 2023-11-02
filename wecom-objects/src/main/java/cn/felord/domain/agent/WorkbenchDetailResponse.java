package cn.felord.domain.agent;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.WorkbenchType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/10/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WorkbenchDetailResponse extends WeComResponse {
    private WorkbenchType type;
    private boolean replaceUserData;
    private Image image;
    private Items items;
    private KeyData keydata;
    private Webview webview;
}
