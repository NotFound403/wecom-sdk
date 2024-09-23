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

package cn.felord.domain.callcenter;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Kf servicer request.
 *
 * @author dax
 * @since 2021 /8/23 15:20
 */
@ToString
@Getter
public class KfServicerRequest {
    private final String openKfid;
    private final List<String> useridList;
    private final List<Integer> departmentIdList;


    /**
     * 既指定员工又指定部门
     *
     * @param openKfid         the open kfid
     * @param useridList       the userid list
     * @param departmentIdList the department id list
     */
    public KfServicerRequest(String openKfid, List<String> useridList, List<Integer> departmentIdList) {
        this.openKfid = openKfid;
        this.useridList = useridList;
        this.departmentIdList = departmentIdList;
    }

    /**
     * 仅指定员工
     *
     * @param openKfid   the open kfid
     * @param useridList the userid list
     * @return the kf servicer request
     */
    public static KfServicerRequest users(String openKfid, List<String> useridList) {
        return new KfServicerRequest(openKfid, useridList, null);
    }

    /**
     * 仅指定部门
     *
     * @param openKfid         the open kfid
     * @param departmentIdList the department id list
     * @return the kf servicer request
     */
    public static KfServicerRequest depts(String openKfid, List<Integer> departmentIdList) {
        return new KfServicerRequest(openKfid, null, departmentIdList);
    }
}
