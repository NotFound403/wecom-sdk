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

import cn.felord.common.MultipartResource;
import cn.felord.mp.MpApp;
import cn.felord.mp.WeMpTokenCacheable;
import cn.felord.mp.api.CardApi;
import cn.felord.mp.api.MediaApi;
import cn.felord.mp.api.WechatMpApi;
import cn.felord.mp.domain.card.*;
import cn.felord.mp.domain.media.MediaUrl;
import cn.felord.mp.enumeration.*;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
        String cardId = "pUSi66OPKdaivX3jeZePoyfOSdkI";
        String cardId2 = "pUSi66Cnn77UPk7IsRm2p6XBEVoc";


//        GenericMpResponse<String> card = cardApi.createCard(new CardRequest<>(create()));
//        System.out.println("card = " + card);
//         MpResponse mpResponse = cardApi.deleteCard(new CardId("pUSi66C-EWJj8AO91SG9a8__Xn0A"));

//        CardQrcodeResponse qrcode = cardApi.createQrcode(new SingleQrcodeRequest(new SingleActionInfo(new SingleCard().cardId(cardId2))));
//        System.out.println("qrcode = " + qrcode);

//        GenericMpResponse<Boolean> booleanGenericMpResponse = cardApi.updateCard(updateCard());
//        System.out.println("booleanGenericMpResponse = " + booleanGenericMpResponse);

        ResponseBody merchantCategory = wechatMpApi.storeMiniProgramApi(mpApp)
                .getMerchantCategory();

        System.out.println("merchantCategory = " + merchantCategory);


    }


    public static UpdateCardRequest updateCard() {
        UpdateBaseInfo baseInfo = new UpdateBaseInfo();
        BonusRule bonusRule = new BonusRule()
                .costMoneyUnit(1000)
                .increaseBonus(1000)
                .maxIncreaseBonus(5000)
                .initIncreaseBonus(100)
                .costBonusUnit(1000)
                .reduceMoney(100)
                .leastMoneyToUseBonus(200000)
                .maxIncreaseBonus(30000);

        UpdateCard updateCard = new UpdateCard(baseInfo)
                .customField3(CustomField.remove())
                .supplyBonus(true)
                .bonusRules("积分有效期为一年；\n积分不可交易；")
                .bonusCleared("次年1月计算清零积分；")
                .bonusRule(bonusRule);
        return UpdateCardRequest.memberCard("pUSi66Cnn77UPk7IsRm2p6XBEVoc", updateCard);
    }


    public static MemberCard create() {
        String bg = "http://mmbiz.qpic.cn/sz_mmbiz_png/ards8DC4cLgibz8vniaexK6QK14LiaSGkXNJ1ZYLgEicFWQaJ83pd0p1oP1STBT6XdlNITYcD80f7gRI5Aw4upQIug/0";

        String logoUrl = "http://mmbiz.qpic.cn/sz_mmbiz_png/ards8DC4cLhnNibKX9Bpdj7DQgiciayHOhJ98rN8qWzY1Giaic7RSruac9kDfDLugmkXN73l7V7Sdajj71pVrMltjnQ/0";


        MemberCardBaseInfo baseInfo = new MemberCardBaseInfo(
                "哈什科技",
                "VIP会员",
                logoUrl,
                CardCodeType.CODE_TYPE_BARCODE,
                "支付时请出示此券",
                "不可与其他优惠同享，\n不兑换不找零，\n满100元可用，\n如需团购券发票，请在消费时向商户提出",
                CardBgColor.COLOR080,
                new Sku(500L),
                DateInfo.permanent())
                .canGiveFriend(false)
                .canShare(false)
                .getLimit(1)
                .useAllLocations(true)
                .servicePhone("400-8888888")
                .customUrl("VIP专区", "汇聚优选", "https://felord.cn")
                .promotionUrl("新品推荐", "欢迎选购", "https://felord.cn");


        AdvancedInfo advancedInfo = new AdvancedInfo()
                .timeLimit(Arrays.asList(new WeekDayLimit(WeekDay.MONDAY),
                        new WeekDayLimit(WeekDay.TUESDAY),
                        new WeekDayLimit(WeekDay.WEDNESDAY),
                        new WeekDayLimit(WeekDay.THURSDAY),
                        new WeekDayLimit(WeekDay.FRIDAY),
                        new WeekDayLimit(WeekDay.SATURDAY),
                        new WeekDayLimit(WeekDay.SUNDAY)
                ))
                .businessService(new HashSet<>(Arrays.asList(BusinessService.BIZ_SERVICE_FREE_WIFI, BusinessService.BIZ_SERVICE_FREE_PARK)));

        MemberCardInfo memberCardInfo = new MemberCardInfo(baseInfo, "持此卡可在本集团门店享受会员权益")
                .backgroundPicUrl(bg)
                .customCell1(new CustomCell("转介绍", "介绍有礼", "https://felord.cn"))
                .customField1(new CustomField(MemberCardFieldType.FIELD_NAME_TYPE_LEVEL, "https://felord.cn"))
                .customField2(new CustomField(MemberCardFieldType.FIELD_NAME_TYPE_COUPON, "https://felord.cn"))
                .customField3(new CustomField(MemberCardFieldType.FIELD_NAME_TYPE_DISCOUNT, "https://felord.cn"))
                .autoActivate(true)
                .advancedInfo(advancedInfo);
        return new MemberCard(memberCardInfo);
    }


    public static void update(MediaApi mediaApi) throws IOException {
        String path = "C:\\Users\\xfa00\\Pictures\\12312321.png";
        InputStream inputStream = Files.newInputStream(Paths.get(path));
        MediaUrl mediaUrl = mediaApi.uploadImg(new MultipartResource("123.png", inputStream));
        System.out.println("mediaUrl = " + mediaUrl);
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
