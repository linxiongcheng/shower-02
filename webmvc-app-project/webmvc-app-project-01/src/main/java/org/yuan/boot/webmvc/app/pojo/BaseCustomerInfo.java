package org.yuan.boot.webmvc.app.pojo;

import java.util.Date;

import lombok.*;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public final class BaseCustomerInfo extends BaseEntity<BaseCustomerInfo> {
    /**
     * id
     */
    private Long id;

    /**
     * actualName
     */
    private String actualName;

    /**
     * contactAddress
     */
    private String contactAddress;

    /**
     * contactNumber
     */
    private String contactNumber;

    /**
     * identityNumber
     */
    private String identityNumber;

    /**
     * enabled
     */
    private Integer enabled;

    /**
     * createUser
     */
    private String createUser;

    /**
     * updateUser
     */
    private String updateUser;

    /**
     * createTime
     */
    private Date createTime;

    /**
     * updateTime
     */
    private Date updateTime;

    public static BaseCustomerInfoBuilder builder() {
        return new BaseCustomerInfoBuilder();
    }
}