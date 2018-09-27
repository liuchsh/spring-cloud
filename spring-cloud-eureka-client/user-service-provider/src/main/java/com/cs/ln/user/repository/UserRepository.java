package com.cs.ln.user.repository;

import com.cs.ln.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link User 用户}仓储
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
@Repository
public class UserRepository {

    // TODO 是否应该声明为static 和 final
    private static final ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();

    /**
     * ID生成器，线程安全
     */
    private static final AtomicLong idGenerator = new AtomicLong();

    public boolean save(User user) {
        long id = idGenerator.getAndIncrement();
        user.setId(id);
        return repository.putIfAbsent(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }

}
