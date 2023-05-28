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
    private final ContactType type;
    private final ContactScene scene;
    private MiniProgramStyle style;
    private String remark;
    private boolean skipVerify = true;
    private String state;
    private String unionid;
    private Set<String> user;
    private Set<Integer> party;
    private boolean isTemp = false;
    private Duration expiresIn;
    private Duration chatExpiresIn;
    private boolean isExclusive = false;
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
