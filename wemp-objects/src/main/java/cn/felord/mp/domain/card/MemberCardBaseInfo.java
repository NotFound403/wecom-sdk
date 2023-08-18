package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CardBgColor;
import cn.felord.mp.enumeration.CardCodeType;
import lombok.Data;

import java.util.List;

/**
 * 基本的卡券数据
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class MemberCardBaseInfo {
    /**
     * 卡券的商户logo，建议像素为300*300
     */
    private final String logoUrl;
    /**
     * 码型
     */
    private final CardCodeType codeType;
    /**
     * 商户名字,字数上限为12个汉字
     */
    private final String brandName;
    /**
     * 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
     */
    private final String title;
    /**
     * 颜色
     */
    private final CardBgColor color;
    /**
     * 卡券使用说明，字数上限为1024个汉字。
     */
    private final String description;
    /**
     * 卡券使用提醒，字数上限为16个汉字。
     */
    private String notice;
    /**
     * 商品信息
     */
    private final Sku sku;
    /**
     * 使用日期，有效期的信息。
     */
    private DateInfo dateInfo;
    /**
     *
     */
    private Integer getLimit;
    /**
     *
     */
    private String customUrlName;
    /**
     *
     */
    private String promotionUrlName;
    /**
     *
     */
    private Boolean canGiveFriend;
    /**
     *
     */
    private List<Integer> locationIdList;
    /**
     *
     */
    private Boolean useCustomCode;
    /**
     *
     */
    private String servicePhone;
    /**
     *
     */
    private String promotionUrl;
    /**
     *
     */
    private String customUrlSubTitle;
    /**
     *
     */
    private Boolean needPushOnView;
    /**
     *
     */
    private String customUrl;

}