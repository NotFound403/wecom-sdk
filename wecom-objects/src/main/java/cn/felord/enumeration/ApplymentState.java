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

package cn.felord.enumeration;

/**
 * 申请状态
 *
 * @author dax
 * @since 2024/7/3 16:08
 */
public enum ApplymentState {
    /**
     * 资料校验中
     */
    CHECKING,
    /**
     * 待签约
     */
    NEED_SIGN,
    /**
     * 待账户验证
     */
    ACCOUNT_NEED_VERIFY,

    /**
     * 完成
     */
    FINISH,

    /**
     * 审核中
     */
    AUDITING,

    /**
     * 已冻结
     */
    FROZEN,

    /**
     * 已驳回
     */
    REJECTED,

    /**
     * 已作废
     */
    CANCELED
}
