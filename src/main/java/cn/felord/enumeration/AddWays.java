package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Add ways.
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum AddWays {
    /**
     * Unknown add ways.
     */
    UNKNOWN(0),
    /**
     * Qr code scanned add ways.
     */
    QR_CODE_SCANNED(1),
    /**
     * Mobile searched add ways.
     */
    MOBILE_SEARCHED(2),
    /**
     * Business card shared add ways.
     */
    BUSINESS_CARD_SHARED(3),
    /**
     * Group chat add ways.
     */
    GROUP_CHAT(4),
    /**
     * Dial book add ways.
     */
    DIAL_BOOK(5),
    /**
     * Wechat list add ways.
     */
    WECHAT_LIST(6),
    /**
     * Via cs when app installing add ways.
     */
    VIA_CS_WHEN_APP_INSTALLING(8),
    /**
     * Email search add ways.
     */
    EMAIL_SEARCH(9),
    /**
     * Wechat channel add ways.
     */
    WECHAT_CHANNEL(10),
    /**
     * Calendar add ways.
     */
    CALENDAR(11),
    /**
     * Meeting add ways.
     */
    MEETING(12),
    /**
     * Work wechat friend add ways.
     */
    WORK_WECHAT_FRIEND(13),
    /**
     * Smart customer service add ways.
     */
    SMART_CUSTOMER_SERVICE(14),
    /**
     * Internal shared add ways.
     */
    INTERNAL_SHARED(201),
    /**
     * Allocation add ways.
     */
    ALLOCATION(202);

    private final int type;

    AddWays(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize add ways.
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static AddWays deserialize(int type) {
        return Arrays.stream(AddWays.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
