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

package cn.felord.domain.corpay.miniapppay;

import cn.felord.enumeration.MiniApyBillType;
import lombok.Data;

import java.time.LocalDate;

/**
 * The type Bill request.
 *
 * @author dax
 * @since 2024/7/7 10:11
 */
@Data
public class BillRequest {
    private final LocalDate billDate;
    private final String mchid;
    private final String tarType;
    private MiniApyBillType billType;


    /**
     * Instantiates a new Bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @param tarType  the tar type
     * @param billType the bill type
     */
    BillRequest(LocalDate billDate, String mchid, String tarType, MiniApyBillType billType) {
        this.billDate = billDate;
        this.mchid = mchid;
        this.tarType = tarType;
        this.billType = billType;
    }

    /**
     * Stream bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @return the bill request
     */
    public static BillRequest stream(LocalDate billDate, String mchid) {
        return new BillRequest(billDate, mchid, null, null);
    }

    /**
     * Stream bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @param billType the bill type
     * @return the bill request
     */
    public static BillRequest stream(LocalDate billDate, String mchid, MiniApyBillType billType) {
        return new BillRequest(billDate, mchid, null, billType);
    }

    /**
     * Gzip bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @return the bill request
     */
    public static BillRequest gzip(LocalDate billDate, String mchid) {
        return new BillRequest(billDate, mchid, "GZIP", null);
    }

    /**
     * Gzip bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @param billType the bill type
     * @return the bill request
     */
    public static BillRequest gzip(LocalDate billDate, String mchid, MiniApyBillType billType) {
        return new BillRequest(billDate, mchid, "GZIP", billType);
    }
}
