/*
 * Copyright (c) 2025. felord.cn
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

package cn.felord.domain.checkin;

import cn.felord.enumeration.CheckinGroupType;
import cn.felord.enumeration.CheckinMethodType;
import cn.felord.enumeration.CheckinOutRange;
import cn.felord.enumeration.CheckinType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * The type Check in group.
 */
@Data
public class CheckinGroup {
    /**
     * 打卡规则类型
     */
    private CheckinGroupType grouptype;
    /**
     * 打卡规则id
     */
    private Integer groupid;
    /**
     * 打卡规则名称
     */
    private String groupname;
    /**
     * 打卡时间，当规则类型为排班时没有意义
     */
    private List<CheckinDate> checkindate;
    /**
     * 特殊日期-必须打卡日期信息
     */
    private List<SpeWorkday> speWorkdays;
    /**
     * 特殊日期-不用打卡日期信息
     */
    private List<SpeOffDay> speOffdays;
    /**
     * 是否同步法定节假日，true为同步，false为不同步，当前排班不支持
     */
    private Boolean syncHolidays;
    /**
     * 是否打卡必须拍照，true为必须拍照，false为不必须拍照
     */
    private Boolean needPhoto;
    /**
     * 是否备注时允许上传本地图片，true为允许，false为不允许
     */
    private Boolean noteCanUseLocalPic;
    /**
     * 是否非工作日允许打卡,true为允许，false为不允许
     */
    private Boolean allowCheckinOffworkday;
    /**
     * 是否允许提交补卡申请，true为允许，false为不允许
     */
    private Boolean allowApplyOffworkday;
    /**
     * 打卡地点-WiFi打卡信息
     */
    private List<WifimacInfo> wifimacInfos;
    /**
     * 打卡地点-位置打卡信息
     */
    private List<LocInfo> locInfos;
    /**
     * 汇报对象信息
     */
    private Reporterinfo reporterinfo;
    /**
     * 范围外打卡处理方式，0-视为范围外异常，默认值；1-视为正常外勤；2:不允许范围外打卡
     */
    private CheckinOutRange optionOutRange;
    /**
     * 打开人脸实时检测
     */
    private Boolean openFaceLiveDetect;
    /**
     * 允许申请Bk次数
     */
    private Integer allowApplyBkCnt;
    /**
     * 打卡人员信息
     */
    private Range range;
    /**
     * 打卡方式
     */
    private CheckinType type;
    /**
     * 加班配置V2
     */
    private OtInfoV2 otInfoV2;
    /**
     * allowApplyBkDayLimit
     */
    private Integer allowApplyBkDayLimit;
    /**
     * bukaLimitNextMonth
     */
    private Integer bukaLimitNextMonth;
    /**
     * 补卡提醒配置
     */
    private BukaRemind bukaRemind;
    /**
     * TODO 进一步封装
     * 补卡指定异常类型，按比特位设置，大端模式，某位bit置位为1表示关闭某类型。
     * 从低到高四个比特位分别表示缺卡类型、迟到类型、早退类型、其他异常类型。
     * 为默认值0表示所有异常类型均允许补卡。
     */
    private Integer bukaRestriction;
    /**
     * 自由上下班
     * <p>
     * 自由上下班规则的跨天时间，表示为距离0点的秒数，必须为整分钟的秒数，且小于24小时。
     * @since 1.3.4
     */
    private Integer spanDayTime;
    /**
     * 自由上下班
     * <p>
     * 自由上下班规则的工作时长（秒），-1表示不限制工作时长，
     * 否则值应该以半小时为步长，从1小时开始递增，最多不超过24小时。
     * 如：1小时，1.5小时，2小时，2.5小时...23小时，23.5小时，24小时。
     *
     * @since 1.3.4
     */
    private Integer standardWorkDuration;
    /**
     * 是否开启审批打卡
     *
     * @since 1.3.4
     */
    private Boolean openSpCheckin;
    /**
     * 打卡交替方式，0-多组交替，1-单组交替，2-仅记录打卡时间。
     * 对固定上下班和排班上下班是休息才生效，自由签到都生效
     *
     * @since 1.3.4
     */
    private CheckinMethodType checkinMethodType;
    /**
     * 创建时间
     */
    private Instant createTime;
    /**
     * 创建人
     */
    private String createUserid;
    /**
     * 更新人
     */
    private String updateUserid;
    /**
     * 打卡人员白名单，即不需要打卡人员，需要有设置白名单才能查看
     */
    private List<String> whiteUsers;
    /**
     * 排班信息
     */
    private List<CheckinSchedule> schedulelist;
    /**
     * 人脸识别打卡开关，true为启用，false为不启用
     */
    private Boolean useFaceDetect;
    /**
     * 同步签入
     */
    private Boolean syncOutCheckin;
    /**
     * 加班信息，相关信息需要设置后才能显示
     */
    private OtInfo otInfo;
    /**
     * 自由签到，上班打卡后xx秒可打下班卡
     */
    private Integer offworkIntervalTime;
}
