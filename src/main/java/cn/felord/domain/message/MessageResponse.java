package cn.felord.domain.message;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author felord
 * @since 2021/11/22 11:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageResponse extends WeComResponse {
    private String invaliduser;
    private String invalidparty;
    private String invalidtag;
    private String unlicenseduser;
    private String msgid;
    private String responseCode;

    public List<String> toInvaliduserList() {
        return toList(invaliduser);
    }

    public List<String> toInvalidpartyList() {
        return toList(invalidparty);
    }

    public List<String> toInvalidtagList() {
        return toList(invalidtag);
    }

    public List<String> toUnlicenseduserList() {
        return toList(unlicenseduser);
    }


    private List<String> toList(String listStr) {
        return Optional.ofNullable(listStr)
                .map(s ->
                        Arrays.stream(listStr.split("\\|"))
                                .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

    }
}
