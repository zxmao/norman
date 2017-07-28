package com.junxiong.norman.repo;

import com.google.common.base.Strings;
import com.junxiong.norman.entity.QUser;
import com.junxiong.norman.entity.User;
import com.querydsl.core.BooleanBuilder;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@Repository
public interface UserRepo extends BaseRepository<User,Long> {

    default Page<User> findAll(Condition condition, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        if (!Strings.isNullOrEmpty(condition.getName())) {
            builder.and(QUser.user.accountName.like(condition.getName()));
        }
        if (!Strings.isNullOrEmpty(condition.getUserEmail())) {
            builder.and(QUser.user.email.eq(condition.getUserEmail()));
        }
        return findAll(builder, pageable);
    }

    @Data
    class Condition {
        private String name;
        private String userEmail;
    }
}
