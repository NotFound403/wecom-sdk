package cn.felord.mp.api;

import cn.felord.mp.MpApp;
import cn.felord.mp.WeMpTokenCacheable;
import cn.felord.mp.retrofit.AccessTokenApi;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * The type Wechat mp api.
 *
 * @author xiafang
 * @since 2023 /8/18 9:09
 */
public class WechatMpApi {
    private final WeMpTokenCacheable weMpTokenCacheable;
    private final HttpLoggingInterceptor.Level level;
    private final ConnectionPool connectionPool;

    /**
     * Instantiates a new Work we chat api.
     *
     * @param weMpTokenCacheable the we com token cacheable
     */
    public WechatMpApi(WeMpTokenCacheable weMpTokenCacheable) {
        this(weMpTokenCacheable, new ConnectionPool());
    }

    /**
     * 推荐生产使用
     *
     * @param weMpTokenCacheable the we com token cacheable
     * @param connectionPool     the connection pool
     */
    public WechatMpApi(WeMpTokenCacheable weMpTokenCacheable, ConnectionPool connectionPool) {
        this(weMpTokenCacheable, connectionPool, HttpLoggingInterceptor.Level.NONE);
    }

    /**
     * Instantiates a new Work we chat api.
     *
     * @param weMpTokenCacheable the we com token cacheable
     * @param level              the level
     */
    public WechatMpApi(WeMpTokenCacheable weMpTokenCacheable, HttpLoggingInterceptor.Level level) {
        this(weMpTokenCacheable, new ConnectionPool(), level);
    }

    /**
     * 开发使用，输出log
     *
     * @param weMpTokenCacheable the we com token cacheable
     * @param connectionPool     the connection pool
     * @param level              the level
     */
    public WechatMpApi(WeMpTokenCacheable weMpTokenCacheable, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        this.weMpTokenCacheable = weMpTokenCacheable;
        this.connectionPool = connectionPool;
        this.level = level;
    }

    /**
     * Media api media api.
     *
     * @param mpApp the mp app
     * @return the media api
     */
    public MediaApi mediaApi(MpApp mpApp) {
        AccessTokenApi tokenApi = new AccessTokenApi(weMpTokenCacheable, mpApp);
        return new MediaApi(WeChatMpApiClient.init(tokenApi, connectionPool, level).retrofit());
    }

    /**
     * Card api card api.
     *
     * @param mpApp the mp app
     * @return the card api
     */
    public CardApi cardApi(MpApp mpApp) {
        AccessTokenApi tokenApi = new AccessTokenApi(weMpTokenCacheable, mpApp);
        return WeChatMpApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(CardApi.class);
    }

}
