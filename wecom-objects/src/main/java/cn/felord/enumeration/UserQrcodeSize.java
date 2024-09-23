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
 * The enum User qrcode size.
 *
 * @author n1
 * @since 2021 /6/17 19:52
 */
public enum UserQrcodeSize {
    /**
     * 171 x 171
     */
    SIZE_171("1"),
    /**
     * 399 x 399
     */
    SIZE_399("2"),
    /**
     * 741 x 741
     */
    SIZE_741("3"),
    /**
     * 2052 x 2052
     */
    SIZE_2052("4");
    private final String size;

    UserQrcodeSize(String size) {
        this.size = size;
    }

    /**
     * Type string.
     *
     * @return the string
     */
    public String type() {
        return size;
    }

}
