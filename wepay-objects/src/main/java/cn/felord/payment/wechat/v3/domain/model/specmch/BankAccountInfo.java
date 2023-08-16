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

package cn.felord.payment.wechat.v3.domain.model.specmch;

import lombok.Data;

@Data
public class BankAccountInfo {
    private String bankAccountType;
    private String accountName;
    private String accountBank;
    private String bankAddressCode;
    private String bankBranchId;
    private String bankName;
    private String accountNumber;
    private AccountCertInfo accountCertInfo;
}