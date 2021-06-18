package cn.felord.domain.contactbook.tag;

import lombok.Data;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/18 15:50
 */
@Data
public class TagUserRequest {
    private Integer tagId;
    private List<String> userlist;
    private List<Integer> partylist;
}
