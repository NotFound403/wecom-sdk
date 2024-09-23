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

package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import cn.felord.domain.agent.AgentMenuBtn;
import cn.felord.domain.agent.AgentMenuBtns;
import cn.felord.domain.agent.AgentSettingRequest;
import cn.felord.domain.agent.Image;
import cn.felord.domain.agent.ImageWorkbenchTemplate;
import cn.felord.domain.agent.Items;
import cn.felord.domain.agent.KeyData;
import cn.felord.domain.agent.KeyDataWorkbenchTemplate;
import cn.felord.domain.agent.ListWorkbenchTemplate;
import cn.felord.domain.agent.UserImageWorkbenchTemplate;
import cn.felord.domain.agent.UserKeyDataWorkbenchTemplate;
import cn.felord.domain.agent.UserListWorkbenchTemplate;
import cn.felord.domain.agent.UserWebviewWorkbenchTemplate;
import cn.felord.domain.agent.UserWorkBenchSetting;
import cn.felord.domain.agent.UserWorkbenchTemplate;
import cn.felord.domain.agent.Webview;
import cn.felord.domain.agent.WebviewWorkbenchTemplate;
import cn.felord.domain.agent.WorkBenchSetting;
import cn.felord.domain.agent.WorkbenchDetailResponse;
import cn.felord.domain.agent.WorkbenchTemplate;
import cn.felord.enumeration.WorkbenchType;
import retrofit2.Retrofit;
import retrofit2.http.Body;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 应用管理
 *
 * @author dax
 * @since 2024 /6/27 11:33
 */
public class AgentManagerApi {
    private final InternalAgentManagerApi internalAgentManagerApi;
    private final AgentDetails agentDetails;

    /**
     * Instantiates a new Agent manager api.
     *
     * @param retrofit     the retrofit
     * @param agentDetails the agent details
     */
    AgentManagerApi(Retrofit retrofit, AgentDetails agentDetails) {
        this.internalAgentManagerApi = retrofit.create(InternalAgentManagerApi.class);
        this.agentDetails = agentDetails;
    }

    /**
     * 获取应用
     * <p>
     * 获取指定的应用详情
     * <p>
     * 对于互联企业的应用，如果需要获取应用可见范围内其他互联企业的部门与成员，请调用互联企业-获取应用可见范围接口
     *
     * @return the agent details
     * @throws WeComException the weComException
     */
    public AgentDetailsResponse getAgentDetails() throws WeComException {
        return this.getAgentDetails(agentDetails.getAgentId());
    }

    /**
     * 获取应用，需保证应用ID参数和Token一致
     *
     * @param agentId the agent id
     * @return the agent details
     * @throws WeComException the we com exception
     */
    public AgentDetailsResponse getAgentDetails(String agentId) throws WeComException {
        return internalAgentManagerApi.getAgentDetails(agentId);
    }

    /**
     * 设置应用
     *
     * @param request the request
     * @return WeComResponse
     * @throws WeComException the weComException
     */
    public WeComResponse settings(AgentSettingRequest request) throws WeComException {
        return internalAgentManagerApi.settings(Settings.from(agentDetails.getAgentId(), request));
    }

    /**
     * 创建菜单
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    public WeComResponse createMenu(AgentMenuBtns request) throws WeComException {
        return internalAgentManagerApi.createMenu(agentDetails.getAgentId(), request);
    }

    /**
     * 获取菜单
     *
     * @return the menu
     * @throws WeComException the weComException
     */
    public GenericResponse<List<AgentMenuBtn>> getMenu() throws WeComException {
        return internalAgentManagerApi.getMenu(agentDetails.getAgentId());
    }

    /**
     * 删除菜单
     *
     * @return the we com response
     * @throws WeComException the weComException
     */
    public WeComResponse deleteMenu() throws WeComException {
        return internalAgentManagerApi.deleteMenu(agentDetails.getAgentId());
    }

    /**
     * 设置应用在工作台展示的模版
     * <p>
     * 该接口指定应用自定义模版类型。同时也支持设置企业默认模版数据。若type指定为 "normal" 则为取消自定义模式，改为普通展示模式
     *
     * @param setting the setting
     * @return the workbench template
     * @throws WeComException the weComException
     */
    public WeComResponse setWorkbenchTemplate(WorkBenchSetting<?> setting) throws WeComException {

        String agentId = agentDetails.getAgentId();
        boolean replaceUserData = setting.isReplaceUserData();
        WorkbenchTemplate template = WorkbenchTemplate.normal(agentId, replaceUserData);
        WorkbenchType type = setting.getType();

        if (Objects.equals(WorkbenchType.KEY_DATA, type)) {
            template = new KeyDataWorkbenchTemplate(agentId, replaceUserData, (KeyData) setting.getBody());
        } else if (Objects.equals(WorkbenchType.IMAGE, type)) {
            template = new ImageWorkbenchTemplate(agentId, replaceUserData, (Image) setting.getBody());
        } else if (Objects.equals(WorkbenchType.LIST, type)) {
            template = new ListWorkbenchTemplate(agentId, replaceUserData, (Items) setting.getBody());
        } else if (Objects.equals(WorkbenchType.WEBVIEW, type)) {
            template = new WebviewWorkbenchTemplate(agentId, replaceUserData, (Webview) setting.getBody());
        }
        return internalAgentManagerApi.setWorkbenchTemplate(template);
    }

    /**
     * 获取应用在工作台展示的模版
     *
     * @return the workbench template
     * @throws WeComException the weComException
     */
    public WorkbenchDetailResponse getWorkbenchTemplate() throws WeComException {
        return internalAgentManagerApi.getWorkbenchTemplate(Collections.singletonMap("agentid", agentDetails.getAgentId()));
    }


    /**
     * 设置应用在用户工作台展示的数据
     * <p>
     * 可设置当前凭证对应的应用；设置的userid必须在应用可见范围；
     * 每个用户每个应用接口限制10次/分钟；
     *
     * @param userSetting the user setting
     * @return the workbench data
     * @throws WeComException the weComException
     */
    public WeComResponse setWorkbenchData(@Body UserWorkBenchSetting<?> userSetting) throws WeComException {
        String agentId = agentDetails.getAgentId();
        String userid = userSetting.getUserid();
        UserWorkbenchTemplate template;
        WorkbenchType type = userSetting.getType();

        if (Objects.equals(WorkbenchType.KEY_DATA, type)) {
            template = new UserKeyDataWorkbenchTemplate(agentId, userid, (KeyData) userSetting.getBody());
        } else if (Objects.equals(WorkbenchType.IMAGE, type)) {
            template = new UserImageWorkbenchTemplate(agentId, userid, (Image) userSetting.getBody());
        } else if (Objects.equals(WorkbenchType.LIST, type)) {
            template = new UserListWorkbenchTemplate(agentId, userid, (Items) userSetting.getBody());
        } else if (Objects.equals(WorkbenchType.WEBVIEW, type)) {
            template = new UserWebviewWorkbenchTemplate(agentId, userid, (Webview) userSetting.getBody());
        } else {
            throw new WeComException("invalid workbench type");
        }

        return internalAgentManagerApi.setWorkbenchData(template);
    }

    /**
     * The type Settings.
     */
    static class Settings extends AgentSettingRequest {
        private final String agentid;


        /**
         * From settings.
         *
         * @param agentid the agentid
         * @param request the request
         * @return the settings
         */
        static Settings from(String agentid, AgentSettingRequest request) {
            Settings settings = new Settings(agentid);
            settings.setDescription(request.getDescription());
            settings.setHomeUrl(request.getHomeUrl());
            settings.setIsreportenter(request.getIsreportenter());
            settings.setLogoMediaid(request.getLogoMediaid());
            settings.setName(request.getName());
            settings.setRedirectDomain(request.getRedirectDomain());
            settings.setReportLocationFlag(request.getReportLocationFlag());
            return settings;
        }

        private Settings(String agentid) {
            this.agentid = agentid;
        }

        /**
         * Gets agentid.
         *
         * @return the agentid
         */
        public String getAgentid() {
            return agentid;
        }
    }
}
