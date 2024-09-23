
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

package cn.felord.domain.corpay.external.account;

import cn.felord.enumeration.BankAccountType;
import lombok.Data;

/**
 * 账户信息
 *
 * @author dax
 * @see <a href="https://developer.work.weixin.qq.com/document/path/98973#account_number">对公、对私卡号长度要求表</a>
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/download/%E3%80%8A%E5%BC%80%E6%88%B7%E9%93%B6%E8%A1%8C%E5%85%A8%E7%A7%B0%EF%BC%88%E5%90%AB%E6%94%AF%E8%A1%8C%EF%BC%89%E5%AF%B9%E7%85%A7%E8%A1%A8%E3%80%8B-2020.06.16.xlsx">开户银行全称对照表</a>
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/download/%E7%9C%81%E5%B8%82%E5%8C%BA%E7%BC%96%E5%8F%B7%E5%AF%B9%E7%85%A7%E8%A1%A8.xlsx">省市区编号对照表</a>
 * @since 2024/6/29
 */
@Data
public class AccountInfo {

    private BankAccountType bankAccountType;
    private final String accountBank;
    private final String accountName;
    private final String bankAddressCode;
    private String bankName;
    private final String accountNumber;
    private BankCardSupplement bankCardSupplement;

}
