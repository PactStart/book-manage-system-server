package io.github.zhuyajie666.bookmanagesystem.component;

import com.alibaba.fastjson.JSON;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.ManagerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class TokenManager {

//    private Map<String, Manager> tokenManagerMap = new HashedMap();

    @Autowired
    private RedisTemplate redisTemplate;

    public String generateToken(Manager manager) {
        String token = UUID.randomUUID().toString();
//        tokenManagerMap.put(token, manager);
        ManagerVo managerVo = MapperUtils.map(manager, ManagerVo.class);
        String json = JSON.toJSONString(managerVo);
        redisTemplate.opsForValue().set(token,json,1, TimeUnit.DAYS);
        return token;
    }

    public ManagerVo getByToken(String token) {
//        return tokenManagerMap.get(token);
        Object obj = redisTemplate.opsForValue().get(token);
        return obj == null ? null : JSON.parseObject(obj.toString(),ManagerVo.class);
    }

    public void removeToken(String token) {
        if(token == null) {
            return;
        }
        redisTemplate.delete(token);
    }
}
