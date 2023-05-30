/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

/**
 * 客户联系
 *
 * @author dax
 * @since 2021 /9/8 8:36
 */
public class ExternalContactManager {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new External contact manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ExternalContactManager(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 客户联系「联系我」管理
     *
     * @return the corp service user api
     */
    public ContactMeWayApi contactMeWayApi() {
        return new ContactMeWayApi(workWeChatApiClient);
    }

    /**
     * 客户管理
     *
     * @return the external contact user api
     */
    public ExternalContactUserApi externalContactUserApi() {
        return new ExternalContactUserApi(workWeChatApiClient);
    }

    /**
     * 管理企业标签
     *
     * @return the corp tag api
     */
    public CorpTagApi corpTagApi() {
        return new CorpTagApi(workWeChatApiClient);
    }

    /**
     * 在职继承
     *
     * @return the on transfer api
     */
    public OnTransferApi onTransferApi() {
        return new OnTransferApi(workWeChatApiClient);
    }

    /**
     * 离职继承
     *
     * @return the off transfer api
     */
    public OffTransferApi offTransferApi() {
        return new OffTransferApi(workWeChatApiClient);
    }

    /**
     * 客户群管理
     *
     * @return the groupchat api
     */
    public GroupChatApi groupchatApi() {
        return new GroupChatApi(workWeChatApiClient);
    }

    /**
     * 客户朋友圈
     *
     * @return the moment api
     */
    public MomentApi momentApi() {
        return new MomentApi(workWeChatApiClient);
    }

    /**
     * 消息推送
     *
     * @return the message api
     */
    public GroupMessageApi messageApi() {
        return new GroupMessageApi(workWeChatApiClient);
    }

    /**
     * 统计管理
     *
     * @return the statistic api
     */
    public StatisticApi statisticApi() {
        return new StatisticApi(workWeChatApiClient);
    }

    /**
     * 商品图册管理
     *
     * @return the product album api
     */
    public ProductAlbumApi productAlbumApi() {
        return new ProductAlbumApi(workWeChatApiClient);
    }

    /**
     * 管理聊天敏感词
     *
     * @return the chat intercept rule api
     */
    public ChatInterceptRuleApi chatInterceptRuleApi() {
        return new ChatInterceptRuleApi(workWeChatApiClient);
    }

    /**
     * 获客助手
     *
     * @return the customer acquisition api
     */
    public CustomerAcquisitionApi customerAcquisitionApi() {
        return new CustomerAcquisitionApi(workWeChatApiClient);
    }
}
