package cn.felord.domain.approval;

import cn.felord.enumeration.ContactCtrlMode;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The type Contact value.
 *
 * @author dax
 * @since 2023 /5/27 10:31
 */
@ToString
@Getter
@NoArgsConstructor
public class ContactValue implements ContentDataValue {
    @JsonIgnore
    private ContactCtrlMode contactCtrlMode;
    private List<MemberInfo> members;
    private Set<DeptInfo> departments;

    /**
     * Instantiates a new Contact value.
     *
     * @param members the members
     */

    public void setMembers(List<MemberInfo> members) {
        this.contactCtrlMode = ContactCtrlMode.USER;
        this.members = members;
        this.departments = Collections.emptySet();
    }

    /**
     * Instantiates a new Contact value.
     *
     * @param departments the departments
     */
    public void setDepartments(Set<DeptInfo> departments) {
        this.contactCtrlMode = ContactCtrlMode.DEPARTMENT;
        this.members = Collections.emptyList();
        this.departments = departments;
    }

    /**
     * The type Member info.
     */
    @ToString
    @Getter
    public static class MemberInfo {
        private final String userid;
        private final String name;

        /**
         * Instantiates a new Member info.
         *
         * @param userid the userid
         * @param name   the name
         */
        @JsonCreator
        public MemberInfo(@JsonProperty("userid") String userid, @JsonProperty("name") String name) {
            this.userid = userid;
            this.name = name;
        }
    }

    /**
     * The type Dept info.
     */
    @ToString
    @Getter
    public static class DeptInfo {
        private final Long openapiId;
        private final String name;

        /**
         * Instantiates a new Dept info.
         *
         * @param openapiId the openapi id
         * @param name      the name
         */
        @JsonCreator
        public DeptInfo(@JsonProperty("openapi_id") Long openapiId, @JsonProperty("name") String name) {
            this.openapiId = openapiId;
            this.name = name;
        }
    }
}
