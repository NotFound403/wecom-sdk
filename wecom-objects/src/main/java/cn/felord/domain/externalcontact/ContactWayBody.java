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

package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ContactScene;
import cn.felord.enumeration.ContactType;
import cn.felord.enumeration.MultiStyle;
import cn.felord.enumeration.SingleStyle;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

/**
 * The type Contact way.
 *
 * @author dax
 * @since 2021/7/8 11:21
 */
public class ContactWayBody {
    /**
     * 联系方式类型
     */
    private final ContactType type;
    /**
     * 场景
     */
    private final ContactScene scene;
    /**
     * 在小程序中联系时使用的控件样式，详见附表
     */
    private MiniProgramStyle style;
    /**
     * 联系方式的备注信息，用于助记，不超过30个字符
     */
    private String remark;
    /**
     * 外部客户添加时是否无需验证，默认为true
     */
    private boolean skipVerify = true;
    /**
     * 企业自定义的state参数，用于区分不同的添加渠道，
     * 在调用“获取外部联系人详情”时会返回该参数值，不超过30个字符
     */
    private String state;
    /**
     * 可进行临时会话的客户unionid，该参数仅在is_temp为true时有效，如不指定则不进行限制
     */
    private String unionid;
    /**
     * 使用该联系方式的用户userID列表，在type为1时为必填，且只能有一个
     */
    private Set<String> user;
    /**
     * 使用该联系方式的部门id列表，只在type为2时有效
     */
    private Set<Integer> party;
    /**
     * 是否临时会话模式，true表示使用临时会话模式，默认为false
     */
    private boolean isTemp = false;
    /**
     * 临时会话二维码有效期，以秒为单位。该参数仅在is_temp为true时有效，默认7天，最多为14天
     */
    private Duration expiresIn;
    /**
     * 临时会话有效期，以秒为单位。该参数仅在is_temp为true时有效，默认为添加好友后24小时，最多为14天
     */
    private Duration chatExpiresIn;
    /**
     * 是否开启同一外部企业客户只能添加同一个员工，默认为否，开启后，同一个企业的客户会优先添加到同一个跟进人
     */
    private boolean isExclusive = false;
    /**
     * 结束语，会话结束时自动发送给客户，可参考“结束语定义”，仅在is_temp为true时有效
     */
    private Conclusions conclusions;

    /**
     * Instantiates a new Contact way.
     *
     * @param type  the type
     * @param scene the scene
     */
    ContactWayBody(ContactType type, ContactScene scene) {
        this.type = type;
        this.scene = scene;

    }

    /**
     * Instantiates a new Contact way.
     *
     * @param scene the scene
     * @param user  the user
     */
    ContactWayBody(ContactScene scene, String user) {
        this(ContactType.SINGLE, scene);
        this.user = Collections.singleton(user);
    }

    /**
     * Instantiates a new Contact way.
     *
     * @param scene the scene
     */
    ContactWayBody(ContactScene scene) {
        this(ContactType.MULTI, scene);
    }

    /**
     * Instantiates a new Contact way.
     *
     * @param scene the scene
     * @param party the party
     */
    ContactWayBody(ContactScene scene, Set<Integer> party) {
        this(scene);
        this.party = party;
    }

    /**
     * Instantiates a new Contact way body.
     *
     * @param scene the scene
     * @param party the party
     * @param user  the user
     */
    ContactWayBody(ContactScene scene, Set<Integer> party, Set<String> user) {
        this(scene);
        this.party = party;
        this.user = user;
    }

    /**
     * 单人小程序
     *
     * @param style the style
     * @param user  the user
     * @return the contact way body
     */
    public static ContactWayBody sigleMiniProgramContact(SingleStyle style, String user) {
        ContactWayBody contactWayBody = new ContactWayBody(ContactScene.MINI_PROGRAM, user);
        contactWayBody.style = style;
        return contactWayBody;
    }

    /**
     * 单人二维码
     *
     * @param user the user
     * @return the contact way
     */
    public static ContactWayBody sigleQrContact(String user) {
        return new ContactWayBody(ContactScene.QR_CODE, user);
    }

    /**
     * 多人小程序
     *
     * @param style the style
     * @return the contact way body
     */
    public static ContactWayBody multiMiniProgramContact(MultiStyle style) {
        ContactWayBody contactWayBody = new ContactWayBody(ContactScene.MINI_PROGRAM);
        contactWayBody.style = style;
        return contactWayBody;
    }

    /**
     * 多人小程序指定部门
     *
     * @param style the style
     * @param party the party
     * @return the contact way body
     */
    public static ContactWayBody multiMiniProgramContact(MultiStyle style, Set<Integer> party) {
        ContactWayBody contactWayBody = new ContactWayBody(ContactScene.MINI_PROGRAM, party);
        contactWayBody.style = style;
        return contactWayBody;
    }

    /**
     * 多人小程序指定部门和服务人员
     *
     * @param style the style
     * @param party the party
     * @param user  the user
     * @return the contact way body
     */
    public static ContactWayBody multiMiniProgramContact(MultiStyle style, Set<Integer> party, Set<String> user) {
        ContactWayBody contactWayBody = new ContactWayBody(ContactScene.MINI_PROGRAM, party, user);
        contactWayBody.style = style;
        return contactWayBody;
    }

    /**
     * 多人二维码
     *
     * @return the contact way
     */
    public static ContactWayBody multiQrContact() {
        return new ContactWayBody(ContactScene.QR_CODE);
    }

    /**
     * 多人二维码指定部门
     *
     * @param party the party
     * @return the contact way
     */
    public static ContactWayBody multiQrContact(Set<Integer> party) {
        return new ContactWayBody(ContactScene.QR_CODE, party);
    }

    /**
     * 多人二维码指定部门和服务人员
     *
     * @param party the party
     * @param user  the user
     * @return the contact way
     */
    public static ContactWayBody multiQrContact(Set<Integer> party, Set<String> user) {
        return new ContactWayBody(ContactScene.QR_CODE, party, user);
    }

    /**
     * Sets remark.
     *
     * @param remark the remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Sets skip verify.
     *
     * @param skipVerify the skip verify
     */
    public void setSkipVerify(Boolean skipVerify) {
        this.skipVerify = skipVerify;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets unionid.
     *
     * @param unionid the unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * Sets is temp.
     *
     * @param isTemp the is temp
     */
    public void setIsTemp(Boolean isTemp) {
        this.isTemp = isTemp;
    }

    /**
     * Sets expires in.
     *
     * @param expiresIn the expires in
     */
    public void setExpiresIn(Duration expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * Sets chat expires in.
     *
     * @param chatExpiresIn the chat expires in
     */
    public void setChatExpiresIn(Duration chatExpiresIn) {
        this.chatExpiresIn = chatExpiresIn;
    }

    /**
     * Sets is exclusive.
     *
     * @param isExclusive the is exclusive
     */
    public void setIsExclusive(Boolean isExclusive) {
        this.isExclusive = isExclusive;
    }

    /**
     * Sets conclusions.
     *
     * @param conclusions the conclusions
     */
    public void setConclusions(Conclusions conclusions) {
        this.conclusions = conclusions;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ContactType getType() {
        return type;
    }

    /**
     * Gets scene.
     *
     * @return the scene
     */
    public ContactScene getScene() {
        return scene;
    }

    /**
     * Gets style.
     *
     * @return the style
     */
    public MiniProgramStyle getStyle() {
        return style;
    }

    /**
     * Gets remark.
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Gets skip verify.
     *
     * @return the skip verify
     */
    public Boolean getSkipVerify() {
        return skipVerify;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Gets unionid.
     *
     * @return the unionid
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public Set<String> getUser() {
        return user;
    }

    /**
     * Gets party.
     *
     * @return the party
     */
    public Set<Integer> getParty() {
        return party;
    }

    /**
     * Gets is temp.
     *
     * @return the is temp
     */
    public Boolean getIsTemp() {
        return isTemp;
    }

    /**
     * Gets expires in.
     *
     * @return the expires in
     */
    public Duration getExpiresIn() {
        return expiresIn;
    }

    /**
     * Gets chat expires in.
     *
     * @return the chat expires in
     */
    public Duration getChatExpiresIn() {
        return chatExpiresIn;
    }

    /**
     * Gets is exclusive.
     *
     * @return the is exclusive
     */
    public Boolean getIsExclusive() {
        return isExclusive;
    }

    /**
     * Gets conclusions.
     *
     * @return the conclusions
     */
    public Conclusions getConclusions() {
        return conclusions;
    }

    @Override
    public String toString() {
        return "ContactWayRequest{" +
                "type=" + type +
                ", scene=" + scene +
                ", remark='" + remark + '\'' +
                ", skipVerify=" + skipVerify +
                ", state='" + state + '\'' +
                ", unionid='" + unionid + '\'' +
                ", user=" + user +
                ", party=" + party +
                ", isTemp=" + isTemp +
                ", expiresIn=" + expiresIn +
                ", chatExpiresIn=" + chatExpiresIn +
                ", isExclusive=" + isExclusive +
                ", conclusions=" + conclusions +
                '}';
    }
}
