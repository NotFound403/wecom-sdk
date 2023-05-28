package cn.felord.domain.externalcontact;

import cn.felord.domain.common.UserId;
import cn.felord.enumeration.GroupChatJoinScene;
import cn.felord.enumeration.GroupChatMemberType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/15 19:52
 */
@Data
public class GroupChatDetail {
    private String chatId;
    private String name;
    private String owner;
    private Instant createTime;
    private String notice;
    private List<GroupChatMember> memberList;
    private List<UserId>  adminList;


    @Data
    public static class GroupChatMember {
        private String userid;
        private GroupChatMemberType type;
        private String unionid;
        private Instant joinTime;
        private GroupChatJoinScene joinScene;
        private UserId invitor;
        private String groupNickname;
        private String name;
    }
}
