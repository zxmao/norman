package com.junxiong.norman.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@Entity
@Data
public class User extends AbstractPersistable<Long> {

    private String accountName;
    private String wxOpenId;
    private String wxUnionId;
    private String email;
    private String telephone;
    private String logo;
    private String userPassword;
    private Integer userStatus;
    private Date createTime;
    private String alias;
}
