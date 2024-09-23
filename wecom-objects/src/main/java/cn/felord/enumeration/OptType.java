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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 操作类型
 *
 * @author dax
 * @since 2024/10/9
 */
public enum OptType {

    /**
     * 上传
     */
    UPLOAD(101),
    /**
     * 新建文件夹
     */
    NEW_FOLDER(102),
    /**
     * 下载
     */
    DOWNLOAD(103),
    /**
     * 更新
     */
    UPDATE(104),
    /**
     * 星标
     */
    STAR(105),
    /**
     * 移动
     */
    MOVE(106),
    /**
     * 复制
     */
    COPY(107),
    /**
     * 重命名
     */
    RENAME(108),
    /**
     * 删除
     */
    DELETE(109),
    /**
     * 恢复
     */
    RECOVER(110),
    /**
     * 彻底删除
     */
    DELETE_COMPLETELY(111),
    /**
     * 转发到企业微信
     */
    SHARE_TO_WECOM(112),
    /**
     * 通过链接下载
     */
    DOWNLOAD_VIA_LINK(113),
    /**
     * 获取分享链接
     */
    GET_SHARE_LINK(114),
    /**
     * 修改分享链接
     */
    EDIT_SHARING_LINK(115),
    /**
     * 关闭分享链接
     */
    TURN_OFF_SHARING_LINKS(116),
    /**
     * 收藏
     */
    COLLECTION(117),
    /**
     * 新建文档
     */
    NEW_DOCUMENT(118),
    /**
     * 新建表格
     */
    NEW_TABLE(119),
    /**
     * 打开
     */
    OPEN_IT(121),
    /**
     * 导出文件
     */
    EXPORT_FILE(124),
    /**
     * 添加文件成员
     */
    ADD_FILE_MEMBERS(127),
    /**
     * 修改文件成员权限
     */
    MODIFY_FILE_MEMBER_PERMISSIONS(128),
    /**
     * 移除文件成员
     */
    REMOVE_FILE_MEMBERS(129),
    /**
     * 设置文档水印
     */
    SET_DOCUMENT_WATERMARK(130),
    /**
     * 修改企业内权限
     */
    MODIFY_PERMISSIONS_INTERNAL(131),
    /**
     * 修改企业外权限
     */
    MODIFY_PERMISSIONS_EXTERNAL(132),
    /**
     * 添加快捷入口
     */
    ADD_SHORTCUT(133),
    /**
     * 转发到微信
     */
    SHARE_TO_WECHAT(134),
    /**
     * 预览
     */
    PREVIEW(135),
    /**
     * 权限管理
     */
    PERMISSION_MANAGEMENT(136),
    /**
     * 安全设置
     */
    SECURITY_SETTINGS(139),
    /**
     * 通过邮件分享
     */
    SHARE_VIA_EMAIL(140),
    /**
     * 离职成员文件转交
     */
    TRANS_OF_DOC_DEPART_MEMBER(142),
    /**
     * 通过下载申请
     */
    APPLY_DOWNLOAD(10001),
    /**
     * 拒绝下载申请
     */
    REJECT_DOWNLOAD(10002);

    private final int type;

    OptType(int type) {
        this.type = type;
    }

    /**
     * Deserialize OptType
     *
     * @param type the type
     * @return the opt type
     */
    @JsonCreator
    public static OptType deserialize(int type) {
        return Arrays.stream(OptType.values())
                .filter(opttype -> opttype.type == type)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }
}
