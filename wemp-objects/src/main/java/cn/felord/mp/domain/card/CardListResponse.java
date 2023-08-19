package cn.felord.mp.domain.card;

import cn.felord.mp.domain.MpResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The type Card list response.
 *
 * @author dax
 * @since 2023 /8/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CardListResponse extends MpResponse {
    private List<UserCardInfo> cardList;
    private boolean hasShareCard;
}
