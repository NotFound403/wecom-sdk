
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


import cn.felord.enumeration.PayBusinessId;
import cn.felord.enumeration.PayOrgType;
import lombok.Data;

/**
 * @author dax
 * @since 2023/6/29
 */
@Data
public class MchAccountRequest {

    private final String outRequestNo;
    private final PayOrgType organizationType;
    private final BusinessLicenseInfo businessLicenseInfo;
    private FinanceInstitutionInfo financeInstitutionInfo;
    private final String merchantShortName;
    private final IdCardInfo idCardInfo;
    private Boolean owner;
    private IdCardInfo uboInfo;
    private final ContactInfoWrapper contactInfo;
    private final AccountInfo accountInfo;
    private final PayBusinessId businessId;
    private MediaIds qualifications;
    private MediaIds businessAdditionPics;
    private final String userid;
}
