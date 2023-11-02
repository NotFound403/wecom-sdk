package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Work bench setting.
 *
 * @param <B> the type parameter
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class UserWorkBenchSetting<B extends WorkBenchBody> {
    /**
     * 工作台类型
     */
    private final WorkbenchType type;
    /**
     * 用户id
     * <p>
     * userid必须在应用可见范围；
     * 每个用户每个应用接口限制10次/分钟；
     */
    private final String userid;
    /**
     * 填充数据，要根据工作台类型来决定
     *
     * @see WorkBenchBody
     */
    private final B body;

    /**
     * Instantiates a new Work bench setting.
     *
     * @param type   the type
     * @param userid the userid
     * @param body   the body
     */
    UserWorkBenchSetting(WorkbenchType type, String userid, B body) {
        this.type = type;
        this.userid = userid;
        this.body = body;
    }

    /**
     * 关键数据型
     *
     * @param userid  the userid
     * @param keyData the key data
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<KeyData> keyData(String userid, KeyData keyData) {
        return new UserWorkBenchSetting<>(WorkbenchType.KEY_DATA, userid, keyData);
    }


    /**
     * 图片型
     *
     * @param userid the userid
     * @param image  the image
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<Image> image(String userid, Image image) {
        return new UserWorkBenchSetting<>(WorkbenchType.IMAGE, userid, image);
    }

    /**
     * 列表型
     *
     * @param userid the userid
     * @param items  the items
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<Items> list(String userid, Items items) {
        return new UserWorkBenchSetting<>(WorkbenchType.LIST, userid, items);
    }

    /**
     * Webview型
     *
     * @param userid  the userid
     * @param webview the webview
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<Webview> webview(String userid, Webview webview) {
        return new UserWorkBenchSetting<>(WorkbenchType.WEBVIEW, userid, webview);
    }

}
