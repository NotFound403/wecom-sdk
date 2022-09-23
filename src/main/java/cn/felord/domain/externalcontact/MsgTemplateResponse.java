package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/22 15:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MsgTemplateResponse extends WeComResponse {
    private Set<String> failList;
    private String msgid;
}
