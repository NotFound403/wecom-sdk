
package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dax
 * @since 2023/5/19 22:23
 */
@Data
public class Item {

    @JsonProperty("ItemImage")
    private String itemImage;
    @JsonProperty("ItemName")
    private String itemName;
    @JsonProperty("ItemOpTime")
    private Long itemOpTime;
    @JsonProperty("ItemParty")
    private String itemParty;
    @JsonProperty("ItemSpeech")
    private String itemSpeech;
    @JsonProperty("ItemStatus")
    private Long itemStatus;
    @JsonProperty("ItemUserId")
    private String itemUserId;

}
