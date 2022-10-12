package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/8 16:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ContactListResponse extends CursorWeComResponse {
    private List<ContactWayItem> contactWay;

    @Data
    public static class ContactWayItem {
        private String configId;
    }

}
