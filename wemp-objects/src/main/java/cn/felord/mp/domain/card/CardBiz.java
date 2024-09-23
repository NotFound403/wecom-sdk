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
 * 卡券概况数据
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class CardBiz {
    /**
     * 转赠次数
     */
    private Integer givenCnt;
    /**
     * 使用次数
     */
    private Integer verifyCnt;
    /**
     * 使用人数
     */
    private Integer verifyUser;
    /**
     * 浏览次数
     */
    private Integer viewCnt;
    /**
     * 领取人数
     */
    private Integer receiveUser;
    /**
     * 日期信息
     */
    private LocalDate refDate;
    /**
     * 领取次数
     */
    private Integer receiveCnt;
    /**
     * 转赠人数
     */
    private Integer givenUser;
    /**
     * 浏览人数
     */
    private Integer viewUser;
    /**
     * 过期次数
     */
    private Integer expireCnt;
    /**
     * 过期人数
     */
    private Integer expireUser;
}
