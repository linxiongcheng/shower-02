package org.yuan.boot.shower.db.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yuan.boot.shower.commons.pojo.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerInfo extends BaseEntity implements Serializable {
    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户OPENID
     */
    private String openId;

    /**
     * 用户UNIONID
     */
    private String unionId;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 电话
     */
    private String phone;

    private static final long serialVersionUID = 1L;
}