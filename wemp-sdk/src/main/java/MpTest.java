/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import cn.felord.json.JacksonObjectMapperFactory;
import cn.felord.mp.MpApp;
import cn.felord.mp.WeMpTokenCacheable;
import cn.felord.mp.api.CardApi;
import cn.felord.mp.api.MediaApi;
import cn.felord.mp.api.WechatMpApi;
import cn.felord.mp.domain.card.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dax
 * @since 2023/8/18
 */
public class MpTest {
    public static void main(String[] args) throws IOException {
        //② 定义缓存 全局定义一次即可
        WeMpTokenCacheable weMpTokenCacheable = new Cache();
        //③ 初始化API入口，建议注入Spring IoC
        WechatMpApi wechatMpApi = new WechatMpApi(weMpTokenCacheable, HttpLoggingInterceptor.Level.BODY);

        MpApp mpApp = new MpApp("wxdef0aeabe9baaeab", "ee45701fc36b9acf0d0974d30d145f0e");
        MediaApi mediaApi = wechatMpApi.mediaApi(mpApp);
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\23234.png");
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Pictures\\jenkins.png");
//        MpResponse<String> responseBody = mediaApi.uploadImg(new MultipartResource("23234.png", fileInputStream));
//        System.out.println(responseBody);
// pUSi66OPKdaivX3jeZePoyfOSdkI

        CardApi cardApi = wechatMpApi.cardApi(mpApp);
//        ResponseBody responseBody = cardApi.create(toRequest());
//        System.out.println("responseBody = " + responseBody);

        CardLandingRequest request = new CardLandingRequest();

        request.setPageTitle("会员卡");
        request.setCanShare(false);
        request.setBanner("http://mmbiz.qpic.cn/sz_mmbiz_png/ards8DC4cLgibz8vniaexK6QK14LiaSGkXNJ1ZYLgEicFWQaJ83pd0p1oP1STBT6XdlNITYcD80f7gRI5Aw4upQIug/0");
        request.setScene("SCENE_QRCODE");
        CardIdInfo idInfo = new CardIdInfo();
        idInfo.setCardId("pUSi66OPKdaivX3jeZePoyfOSdkI");
        idInfo.setThumbUrl("https://cdn.pixabay.com/photo/2017/03/16/21/18/logo-2150297_1280.png");
        request.setCardList(Collections.singletonList(idInfo));
//        CardLandingResponse landingpage = cardApi.landingpage(request);


        CardUpdateUserResponse updateuser = cardApi.updateuser(to());

        System.out.println("updateuser = " + updateuser);


    }


    public static CardUpdateUserRequest to() throws JsonProcessingException {
        String json = "{\n" +
                "  \"code\": \"366021428358\",\n" +
                "  \"card_id\": \"pUSi66OPKdaivX3jeZePoyfOSdkI\",\n" +
                "  \"record_bonus\": \"1500积分兑换周边\",\n" +
                "  \"bonus\": 1500,\n" +
                "  \"add_bonus\": -1500,\n" +
                "  \"notify_optional\": {\n" +
                "    \"is_notify_bonus\": true,\n" +
                "    \"is_notify_custom_field1\":true\n" +
                "  }\n" +
                "}";

        return JacksonObjectMapperFactory.create().readValue(json, CardUpdateUserRequest.class);
    }


    public static CardRequest toRequest() throws JsonProcessingException {

        String json = "{\n" +
                "    \"card\": {\n" +
                "        \"card_type\": \"MEMBER_CARD\",\n" +
                "        \"member_card\": {\n" +
                "            \"background_pic_url\": \"http://mmbiz.qpic.cn/sz_mmbiz_png/ards8DC4cLgibz8vniaexK6QK14LiaSGkXNJ1ZYLgEicFWQaJ83pd0p1oP1STBT6XdlNITYcD80f7gRI5Aw4upQIug/0\",\n" +
                "            \"base_info\": {\n" +
                "                \"logo_url\": \"http://mmbiz.qpic.cn/sz_mmbiz_png/ards8DC4cLgibz8vniaexK6QK14LiaSGkXNc7vnmJIasOiaVvAF5YHRLknYb0nbLIxZjPxSAN5uhQyicWIjJSCASibDA/0\",\n" +
                "                \"brand_name\": \"12312\",\n" +
                "                \"code_type\": \"CODE_TYPE_TEXT\",\n" +
                "                \"title\": \"1231\",\n" +
                "                \"color\": \"Color010\",\n" +
                "                \"notice\": \"使用时向服务员出示此券\",\n" +
                "                \"service_phone\": \"020-88888888\",\n" +
                "                \"description\": \"不可与其他优惠同享\",\n" +
                "                \"date_info\": {\n" +
                "                    \"type\": \"DATE_TYPE_PERMANENT\"\n" +
                "                },\n" +
                "                \"sku\": {\n" +
                "                    \"quantity\": 50000000\n" +
                "                },\n" +
                "                \"get_limit\": 3,\n" +
                "                \"use_custom_code\": false,\n" +
                "                \"can_give_friend\": true,\n" +
                "                \"location_id_list\": [\n" +
                "                    123,\n" +
                "                    12321\n" +
                "                ],\n" +
                "                \"custom_url_name\": \"立即使用\",\n" +
                "                \"custom_url\": \"http://weixin.qq.com\",\n" +
                "                \"custom_url_sub_title\": \"6个汉字tips\",\n" +
                "                \"promotion_url_name\": \"营销入口1\",\n" +
                "                \"promotion_url\": \"http://www.qq.com\",\n" +
                "                \"need_push_on_view\": true\n" +
                "            },\n" +
                "             \"advanced_info\": {\n" +
                "               \"use_condition\": {\n" +
                "                   \"accept_category\": \"鞋类\",\n" +
                "                   \"reject_category\": \"阿迪达斯\",\n" +
                "                   \"can_use_with_other_discount\": true\n" +
                "               },\n" +
                "               \"text_image_list\": [\n" +
                "                   {\n" +
                "                       \"image_url\": \"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\n" +
                "                       \"text\": \"此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾\"\n" +
                "                   },\n" +
                "                   {\n" +
                "                       \"image_url\": \"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\n" +
                "                       \"text\": \"此菜品迎合大众口味，老少皆宜，营养均衡\"\n" +
                "                   }\n" +
                "               ],\n" +
                "               \"time_limit\": [\n" +
                "                   {\n" +
                "                       \"type\": \"MONDAY\",\n" +
                "                       \"begin_hour\":0,\n" +
                "                       \"end_hour\":10,\n" +
                "                       \"begin_minute\":10,\n" +
                "                       \"end_minute\":59\n" +
                "                   },\n" +
                "                   {\n" +
                "                       \"type\": \"HOLIDAY\"\n" +
                "                   }\n" +
                "               ],\n" +
                "               \"business_service\": [\n" +
                "                   \"BIZ_SERVICE_FREE_WIFI\",\n" +
                "                   \"BIZ_SERVICE_WITH_PET\",\n" +
                "                   \"BIZ_SERVICE_FREE_PARK\",\n" +
                "                   \"BIZ_SERVICE_DELIVER\"\n" +
                "               ]\n" +
                "           },\n" +
                "            \"supply_bonus\": true,\n" +
                "            \"supply_balance\": false,\n" +
                "            \"prerogative\": \"test_prerogative\",\n" +
                "            \"auto_activate\": true,\n" +
                "            \"custom_field1\": {\n" +
                "                \"name_type\": \"FIELD_NAME_TYPE_LEVEL\",\n" +
                "                \"url\": \"http://www.qq.com\"\n" +
                "            },\n" +
                "            \"activate_url\": \"http://www.qq.com\",\n" +
                "            \"custom_cell1\": {\n" +
                "                \"name\": \"使用入口2\",\n" +
                "                \"tips\": \"激活后显示\",\n" +
                "                \"url\": \"http://www.qq.com\"\n" +
                "            },\n" +
                "            \"bonus_rule\": {\n" +
                "                \"cost_money_unit\": 100,\n" +
                "                \"increase_bonus\": 1,\n" +
                "                \"max_increase_bonus\": 200,\n" +
                "                \"init_increase_bonus\": 10,\n" +
                "                \"cost_bonus_unit\": 5,\n" +
                "                \"reduce_money\": 100,\n" +
                "                \"least_money_to_use_bonus\": 1000,\n" +
                "                \"max_reduce_bonus\": 50\n" +
                "            },\n" +
                "            \"discount\": 10\n" +
                "        }\n" +
                "    }\n" +
                "}";
        return JacksonObjectMapperFactory.create().readValue(json, CardRequest.class);

    }


    static class Cache implements WeMpTokenCacheable {

        private final Map<String, String> map = new HashMap<>();

        @Override
        public String putAccessToken(String appid, String accessToken) {
            map.put(appid, accessToken);
            return accessToken;
        }

        @Override
        public String getAccessToken(String appid) {
            return map.get(appid);
        }

        @Override
        public void clearAccessToken(String appid) {
            map.remove(appid);
        }

    }
}
