package com.junxiong.norman.mapper;

import com.junxiong.norman.entity.User;
import com.junxiong.norman.dto.UserDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    @InheritConfiguration(name = "summary")
    @Mapping(target = "userEmail", source = "email")
    UserDTO.Detail detail(User s);

    @Mapping(target = "name", source = "accountName")
    @Mapping(target = "opId", source = "wxOpenId")
    @Mapping(target = "unId", source = "wxUnionId")
    UserDTO.Summary summary(User s);

    @Mapping(target = "accountName", source = "name")
    User map(UserDTO s);

    @Mapping(target = "accountName", source = "name")
    @Mapping(target = "wxOpenId", source = "opId")
    @Mapping(target = "wxUnionId", source = "unId")
    @Mapping(target = "email", source = "userEmail")
    @Mapping(target = "createTime", source = "time")
    @Mapping(target = "alias", source = "nickName")
    @Mapping(target = "telephone", source = "mobile")
    User map(UserDTO.AddUser s);
}
