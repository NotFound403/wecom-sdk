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

package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ChatType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

/**
 * 企业群发请求参数
 *
 * @author dax
 * @since 2021 /4/22 14:53
 */
@ToString
@Getter
public class MsgTemplateRequest {
    /**
     * 群发任务的类型
     */
    private final ChatType chatType;
    /**
     * 客户的externaluserid列表，仅在chat_type为single时有效，最多可一次指定1万个客户
     */
    private final Set<String> externalUserid;
    /**
     * 客户群id列表，仅在chat_type为group时有效，最多可一次指定2000个客户群。指定群id之后，收到任务的群主无须再选择客户群
     *
     * @since 1.2.1
     */
    private final Set<String> chatIdList;
    /**
     * 要进行群发的客户标签列表
     *
     * @since 1.2.1
     */
    private final MsgTagFilter tagFilter;
    /**
     * 发送企业群发消息的成员userid，当类型为发送给客户群时必填
     */
    private final String sender;
    /**
     * 是否允许成员在待发送客户列表中重新进行选择，默认为false，仅支持客户群发场景
     */
    private final Boolean allowSelect;
    /**
     * 消息文本内容，最多4000个字节
     */
    private final ContentText text;
    /**
     * 附件，最多支持添加9个附件
     */
    private final List<? extends MsgAttachment> attachments;

    /**
     * Single msg template request.
     *
     * @param sender the sender
     * @param text   the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender, String text) {
        return single(sender, null, false, text);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param text        the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            boolean allowSelect,
                                            String text) {
        return single(sender, null, allowSelect, text);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, false, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            boolean allowSelect,
                                            List<? extends MsgAttachment> attachments) {
        return new MsgTemplateRequest(ChatType.SINGLE,
                null,
                null,
                null,
                sender,
                allowSelect,
                null,
                attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, null, false, text, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            boolean allowSelect,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, null, allowSelect, text, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param externalUserid the external userid
     * @param text           the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(
            Set<String> externalUserid,
            String text) {
        return single(null, externalUserid, false, text);
    }

    /**
     * Single msg template request.
     *
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param text           the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(
            Set<String> externalUserid,
            boolean allowSelect,
            String text) {
        return single(null, externalUserid, allowSelect, text);
    }

    /**
     * Single msg template request.
     *
     * @param externalUserid the external userid
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(
            Set<String> externalUserid,
            List<? extends MsgAttachment> attachments) {
        return single(null, externalUserid, false, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(
            Set<String> externalUserid,
            boolean allowSelect,
            List<? extends MsgAttachment> attachments) {
        return single(null, externalUserid, allowSelect, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param externalUserid the external userid
     * @param text           the text
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(
            Set<String> externalUserid,
            String text,
            List<? extends MsgAttachment> attachments) {
        return single(null, externalUserid, false, text, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param text           the text
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(
            Set<String> externalUserid,
            boolean allowSelect,
            String text,
            List<? extends MsgAttachment> attachments) {
        return single(null, externalUserid, allowSelect, text, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param text           the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            Set<String> externalUserid,
                                            String text) {
        return single(sender, externalUserid, false, null, new ContentText(text));
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param text           the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            Set<String> externalUserid,
                                            boolean allowSelect,
                                            String text) {
        return single(sender, externalUserid, allowSelect, null, new ContentText(text));
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            Set<String> externalUserid,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, externalUserid, false, attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            Set<String> externalUserid,
                                            boolean allowSelect,
                                            List<? extends MsgAttachment> attachments) {
        return new MsgTemplateRequest(ChatType.SINGLE,
                externalUserid,
                null,
                null,
                sender,
                allowSelect,
                null,
                attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param text           the text
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            Set<String> externalUserid,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, externalUserid, false, null, new ContentText(text), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param text           the text
     * @param attachments    the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            Set<String> externalUserid,
                                            boolean allowSelect,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, externalUserid, allowSelect, null, new ContentText(text), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param groupList the group list
     * @param text      the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(List<Set<String>> groupList, String text) {
        return single(null, null, false, new MsgTagFilter(groupList), new ContentText(text));
    }

    /**
     * Single msg template request.
     *
     * @param allowSelect the allow select
     * @param groupList   the group list
     * @param text        the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(boolean allowSelect,
                                            List<Set<String>> groupList,
                                            String text) {
        return single(null, null, allowSelect, new MsgTagFilter(groupList), new ContentText(text));
    }

    /**
     * Single msg template request.
     *
     * @param groupList   the group list
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(List<Set<String>> groupList,
                                            List<? extends MsgAttachment> attachments) {
        return single(null, null, false, new MsgTagFilter(groupList), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param allowSelect the allow select
     * @param groupList   the group list
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(boolean allowSelect,
                                            List<Set<String>> groupList,
                                            List<? extends MsgAttachment> attachments) {
        return single(null, null, allowSelect, new MsgTagFilter(groupList), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param groupList   the group list
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(List<Set<String>> groupList,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(null, null, false, new MsgTagFilter(groupList), new ContentText(text), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param allowSelect the allow select
     * @param groupList   the group list
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(boolean allowSelect,
                                            List<Set<String>> groupList,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(null, null, allowSelect, new MsgTagFilter(groupList), new ContentText(text), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender    the sender
     * @param groupList the group list
     * @param text      the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            List<Set<String>> groupList,
                                            String text) {
        return single(sender, null, false, new MsgTagFilter(groupList), new ContentText(text));
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param groupList   the group list
     * @param text        the text
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            boolean allowSelect,
                                            List<Set<String>> groupList,
                                            String text) {
        return single(sender, null, allowSelect, new MsgTagFilter(groupList), new ContentText(text));
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param groupList   the group list
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            List<Set<String>> groupList,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, null, false, new MsgTagFilter(groupList), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param groupList   the group list
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            boolean allowSelect,
                                            List<Set<String>> groupList,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, null, allowSelect, new MsgTagFilter(groupList), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param groupList   the group list
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            List<Set<String>> groupList,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, null, false, new MsgTagFilter(groupList), new ContentText(text), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param groupList   the group list
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest single(String sender,
                                            boolean allowSelect,
                                            List<Set<String>> groupList,
                                            String text,
                                            List<? extends MsgAttachment> attachments) {
        return single(sender, null, allowSelect, new MsgTagFilter(groupList), new ContentText(text), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param groupList      the group list
     * @param text           the text
     * @return the msg template request
     */
    static MsgTemplateRequest single(String sender,
                                     Set<String> externalUserid,
                                     boolean allowSelect,
                                     List<Set<String>> groupList,
                                     String text) {
        return single(sender, externalUserid, allowSelect, new MsgTagFilter(groupList), new ContentText(text));
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param groupList      the group list
     * @param attachments    the attachments
     * @return the msg template request
     */
    static MsgTemplateRequest single(String sender,
                                     Set<String> externalUserid,
                                     boolean allowSelect,
                                     List<Set<String>> groupList,
                                     List<? extends MsgAttachment> attachments) {
        return single(sender, externalUserid, allowSelect, new MsgTagFilter(groupList), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param groupList      the group list
     * @param text           the text
     * @param attachments    the attachments
     * @return the msg template request
     */
    static MsgTemplateRequest single(String sender,
                                     Set<String> externalUserid,
                                     boolean allowSelect,
                                     List<Set<String>> groupList,
                                     String text,
                                     List<? extends MsgAttachment> attachments) {
        return single(sender, externalUserid, allowSelect, new MsgTagFilter(groupList), new ContentText(text), attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param tagFilter      the tag filter
     * @param text           the text
     * @return the msg template request
     */
    static MsgTemplateRequest single(String sender,
                                     Set<String> externalUserid,
                                     boolean allowSelect,
                                     MsgTagFilter tagFilter,
                                     ContentText text) {

        return single(sender, externalUserid, allowSelect, tagFilter, text, null);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param tagFilter      the tag filter
     * @param attachments    the attachments
     * @return the msg template request
     */
    static MsgTemplateRequest single(String sender,
                                     Set<String> externalUserid,
                                     boolean allowSelect,
                                     MsgTagFilter tagFilter,
                                     List<? extends MsgAttachment> attachments) {

        return new MsgTemplateRequest(ChatType.SINGLE,
                externalUserid,
                null,
                tagFilter,
                sender,
                allowSelect,
                null,
                attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param chatIdList  the chat id list
     * @param allowSelect the allow select
     * @param text        the text
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Set<String> chatIdList,
                                           Boolean allowSelect,
                                           String text) {
        return group(
                sender,
                chatIdList,
                allowSelect,
                new ContentText(text),
                null);
    }

    /**
     * Group msg template request.
     *
     * @param sender     the sender
     * @param chatIdList the chat id list
     * @param text       the text
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Set<String> chatIdList,
                                           String text) {
        return group(
                sender,
                chatIdList,
                false,
                new ContentText(text),
                null);
    }


    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param text        the text
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Boolean allowSelect,
                                           String text) {
        return group(sender, null, allowSelect, text);
    }

    /**
     * Group msg template request.
     *
     * @param sender the sender
     * @param text   the text
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           String text) {
        return group(sender, false, text);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param chatIdList  the chat id list
     * @param allowSelect the allow select
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Set<String> chatIdList,
                                           Boolean allowSelect,
                                           List<? extends MsgAttachment> attachments) {
        return new MsgTemplateRequest(ChatType.GROUP,
                null,
                chatIdList,
                null,
                sender,
                allowSelect,
                null,
                attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param chatIdList  the chat id list
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Set<String> chatIdList,
                                           List<? extends MsgAttachment> attachments) {
        return new MsgTemplateRequest(ChatType.GROUP,
                null,
                chatIdList,
                null,
                sender,
                false,
                null,
                attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Boolean allowSelect,
                                           List<? extends MsgAttachment> attachments) {
        return group(sender, null, allowSelect, attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           List<? extends MsgAttachment> attachments) {
        return group(sender, null, false, attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param chatIdList  the chat id list
     * @param allowSelect the allow select
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Set<String> chatIdList,
                                           Boolean allowSelect,
                                           String text,
                                           List<? extends MsgAttachment> attachments) {
        return group(
                sender,
                chatIdList,
                allowSelect,
                new ContentText(text),
                attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param chatIdList  the chat id list
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Set<String> chatIdList,
                                           String text,
                                           List<? extends MsgAttachment> attachments) {
        return group(
                sender,
                chatIdList,
                false,
                new ContentText(text),
                attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param allowSelect the allow select
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           Boolean allowSelect,
                                           String text,
                                           List<? extends MsgAttachment> attachments) {
        return group(
                sender,
                null,
                allowSelect,
                new ContentText(text),
                attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    public static MsgTemplateRequest group(String sender,
                                           String text,
                                           List<? extends MsgAttachment> attachments) {
        return group(
                sender,
                null,
                false,
                new ContentText(text),
                attachments);
    }

    /**
     * Single msg template request.
     *
     * @param sender         the sender
     * @param externalUserid the external userid
     * @param allowSelect    the allow select
     * @param tagFilter      the tag filter
     * @param text           the text
     * @param attachments    the attachments
     * @return the msg template request
     */
    static MsgTemplateRequest single(String sender,
                                     Set<String> externalUserid,
                                     boolean allowSelect,
                                     MsgTagFilter tagFilter,
                                     ContentText text,
                                     List<? extends MsgAttachment> attachments) {

        return new MsgTemplateRequest(ChatType.SINGLE,
                externalUserid,
                null,
                tagFilter,
                sender,
                allowSelect,
                text,
                attachments);
    }

    /**
     * Group msg template request.
     *
     * @param sender      the sender
     * @param chatIdList  the chat id list
     * @param allowSelect the allow select
     * @param text        the text
     * @param attachments the attachments
     * @return the msg template request
     */
    static MsgTemplateRequest group(String sender,
                                    Set<String> chatIdList,
                                    Boolean allowSelect,
                                    ContentText text,
                                    List<? extends MsgAttachment> attachments) {
        return new MsgTemplateRequest(ChatType.GROUP,
                null,
                chatIdList,
                null,
                sender,
                allowSelect,
                text,
                attachments);
    }

    /**
     * Instantiates a new Msg template request.
     *
     * @param chatType       the chat type
     * @param externalUserid the external userid
     * @param chatIdList     the chat id list
     * @param tagFilter      the tag filter
     * @param sender         the sender
     * @param allowSelect    the allow select
     * @param text           the text
     * @param attachments    the attachments
     */
    MsgTemplateRequest(ChatType chatType,
                       Set<String> externalUserid,
                       Set<String> chatIdList,
                       MsgTagFilter tagFilter,
                       String sender,
                       Boolean allowSelect,
                       ContentText text,
                       List<? extends MsgAttachment> attachments) {
        this.chatType = chatType;
        this.externalUserid = externalUserid;
        this.chatIdList = chatIdList;
        this.tagFilter = tagFilter;
        this.sender = sender;
        this.allowSelect = allowSelect;
        this.text = text;
        this.attachments = attachments;
    }

}
