package com.junxiong.norman.service;

import com.junxiong.norman.entity.City;
import com.junxiong.norman.entity.User;
import com.junxiong.norman.dto.UserDTO;
import com.junxiong.norman.mapper.UserMapper;
import com.junxiong.norman.repo.CityRepo;
import com.junxiong.norman.repo.UserRepo;
import com.junxiong.norman.service.redis.RedisKey;
import com.junxiong.norman.service.redis.RedisService;
import com.junxiong.norman.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RedisService redisService;

    public User getUser(Long id){
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),User.class);
    }

    public List<User> getAllUser(){
        List<User> users = mongoTemplate.findAll(User.class);
        users.sort(Comparator.comparing(User::getCreateTime));
        return users;
    }

    public List<User> saveUser(UserDTO.AddUser addUser){
        User user = userMapper.map(addUser);
        userRepo.save(user);
        mongoTemplate.save(user);

        //redis opt
        String token = StringUtils.getRandomString(16);
        redisService.set(RedisKey.getUserKey(user.getId()),user.toString());
        redisService.set(RedisKey.getUserIdKey(user.getId()), token);
        redisService.set(RedisKey.getUserTokenKey(token),user.getId().toString());

        return mongoTemplate.find(new Query(Criteria.where("accountName").is(user.getAccountName())), User.class);
    }

    public Page<UserDTO.Summary> findAllUser(UserRepo.Condition condition, Pageable pageable) {
        return userRepo.findAll(condition,pageable).map(userMapper::summary);
    }

    public City findCityById(Long id) {
        return cityRepo.findOne(id);
    }
}
