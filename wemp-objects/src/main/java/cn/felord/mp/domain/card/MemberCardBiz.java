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

package cn.felord.mp.domain.card;

import lombok.Data;

import java.time.LocalDate;

/**
 * 会员卡统计
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class MemberCardBiz {
    /**
     * 使用次数
     */
    private Integer verifyCnt;
    /**
     * 使用人数
     */
    private Integer verifyUser;
    /**
     * 激活数量
     */
    private Integer activeCnt;
    /**
     * 激活人数
     */
    private Integer activeUser;
    /**
     * 历史领取会员卡总人数
     */
    private Integer totalReceiveUser;
    /**
     * 有效会员总人数
     */
    private Integer totalUser;
    /**
     * 领取次数
     */
    private Integer receiveCnt;
    /**
     * 领取人数
     */
    private Integer receiveUser;
    /**
     * 日期信息
     */
    private LocalDate refDate;
    /**
     * 浏览次数
     */
    private Integer viewCnt;
    /**
     * 浏览人数
     */
    private Integer viewUser;
}
