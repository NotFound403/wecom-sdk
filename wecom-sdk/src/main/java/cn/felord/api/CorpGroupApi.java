package cn.felord.api;

import cn.felord.DefaultAgent;
import cn.felord.DownStreamDetails;
import cn.felord.WeComTokenCacheable;
import cn.felord.retrofit.AccessTokenApi;
import cn.felord.retrofit.DownStreamTokenApi;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 上下游
 *
 * @author dax
 * @since 2023 /10/12
 */
public class CorpGroupApi {
    private final WeComTokenCacheable weComTokenCacheable;
    private final ConnectionPool connectionPool;
    private final HttpLoggingInterceptor.Level level;

    /**
     * Instantiates a new Corp group api.
     *
     * @param weComTokenCacheable the we com token cacheable
     * @param connectionPool      the connection pool
     * @param level               the level
     */
    CorpGroupApi(WeComTokenCacheable weComTokenCacheable,
                 ConnectionPool connectionPool,
                 HttpLoggingInterceptor.Level level) {
        this.weComTokenCacheable = weComTokenCacheable;
        this.connectionPool = connectionPool;
        this.level = level;
    }


    /**
     * 上游API
     *
     * @param upStreamAgent the up stream agent
     * @return the up stream api
     */
    public UpStreamApi upStreamApi(DefaultAgent upStreamAgent) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, upStreamAgent);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(UpStreamApi.class);
    }

    /**
     * 下游API
     *
     * @param downStreamAgent the down stream agent
     * @return the down stream api
     */
    public DownStreamApi downStreamApi(DownStreamDetails downStreamAgent) {
        DownStreamTokenApi tokenApi = new DownStreamTokenApi(weComTokenCacheable, downStreamAgent);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(DownStreamApi.class);
    }
}
