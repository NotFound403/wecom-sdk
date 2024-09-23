
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

import cn.felord.enumeration.BusinessCertType;
import lombok.Data;

import java.time.LocalDate;

/**
 * 营业执照/登记证书
 *
 * @author dax
 * @see <a href="https://developer.work.weixin.qq.com/document/path/98973#business_license_info">营业执照、登记证书参数说明</a>
 * @since 2023/6/29
 */
@Data
public class BusinessLicenseInfo {

    private final String businessLicenseCopyOpenWxPayMediaId;
    private final String businessLicenseNumber;
    private final String legalPerson;
    private final String merchantName;
    private BusinessCertType certType;
    private LocalDate businessTimeBeginTime;
    private LocalDate businessTimeEndTime;
    private String companyAddress;

}
