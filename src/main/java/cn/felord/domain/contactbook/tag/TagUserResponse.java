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
public class TagUserResponse extends WeComResponse {
     private String tagname;
     private List<TagUser> userlist;
     private List<Integer> partylist;

}
