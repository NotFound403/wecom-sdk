/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.mp.api;

import cn.felord.mp.MpApp;
import cn.felord.mp.WeMpTokenCacheable;
import cn.felord.mp.retrofit.AccessTokenApi;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * The type Wechat mp api.
 *
 * @author dax
 * @since 2024/8/18 9:09
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
     * 素材API
     *
     * @param mpApp the mp app
     * @return the media api
     */
    public MediaApi mediaApi(MpApp mpApp) {
        AccessTokenApi tokenApi = new AccessTokenApi(weMpTokenCacheable, mpApp);
        return new MediaApi(WeChatMpApiClient.init(tokenApi, connectionPool, level).retrofit());
    }

    /**
     * 微信会员卡1.0API
     * <p>
     * 品牌商户可升级为 <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/Offline/open/chapter5_9_1.shtml">会员卡2.0</a>
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

    /**
     * Message api message api.
     *
     * @param mpApp the mp app
     * @return the message api
     */
    public MessageApi messageApi(MpApp mpApp) {
        AccessTokenApi tokenApi = new AccessTokenApi(weMpTokenCacheable, mpApp);
        return WeChatMpApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(MessageApi.class);
    }
}
