package cn.felord.api;

import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 统计管理
 *
 * @author dax
 * @since 2021 /9/23 11:30
 */
public class StatisticApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Statistic api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    StatisticApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取「联系客户统计」数据
     * <p>
     * userid和partyid不可同时为空;
     * 此接口提供的数据以天为维度，查询的时间范围为[start_time,end_time]，即前后均为闭区间，支持的最大查询跨度为30天；
     * 用户最多可获取最近180天内的数据；
     * 当传入的时间不为0点时间戳时，会向下取整，如传入1554296400(Wed Apr 3 21:00:00 CST 2019)会被自动转换为1554220800（Wed Apr 3 00:00:00 CST 2019）;
     * 如传入多个userid，则表示获取这些成员总体的联系客户数据。
     *
     * @param request the request
     * @return the user behavior data
     */
    public UserBehaviorDataResponse getUserBehaviorData(UserBehaviorDataRequest request) {
        String endpoint = WeComEndpoint.STATISTIC_USER_BEHAVIOR_DATA.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, UserBehaviorDataResponse.class);
    }

    /**
     * 获取「群聊数据统计」数据-按群主聚合的方式
     * <p>
     * 此接口查询的时间范围为 [day_begin_time, day_end_time]，前后均为闭区间（即包含day_end_time当天的数据），支持的最大查询跨度为30天；
     * 用户最多可获取最近180天内的数据（超过180天企业微信将不再存储）；
     * 当传入的时间不为0点时，会向下取整，如传入1554296400(Wed Apr 3 21:00:00 CST 2019)会被自动转换为1554220800（Wed Apr 3 00:00:00 CST 2019）;
     *
     * @param request the request
     * @return the group chat data
     */
    public GroupChatDataResponse<GroupChatDataByOwner> getGroupChatDataByOwner(GroupChatOwnerDataRequest request) {
        String endpoint = WeComEndpoint.STATISTIC_GROUP_CHAT_BY_OWNER.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GroupChatDataResponse<GroupChatDataByOwner>>() {
        });
    }

    /**
     * 获取「群聊数据统计」数据-按自然日聚合的方式
     *
     * @param request the request
     * @return the group chat data by day
     */
    public GroupChatDataResponse<GroupChatDataByDay> getGroupChatDataByDay(GroupChatDayDataRequest request) {
        String endpoint = WeComEndpoint.STATISTIC_GROUP_CHAT_BY_DAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GroupChatDataResponse<GroupChatDataByDay>>() {
        });
    }
}