package cn.felord.domain.contactbook.tag;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/18 14:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TagUserActionResponse extends WeComResponse {
     private String invalidlist;
     private List<Long> invalidparty;

}
