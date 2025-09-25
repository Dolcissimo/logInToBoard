package me.sungJ.logInToBoard.infrastructure;

import me.sungJ.logInToBoard.domain.User;
import me.sungJ.logInToBoard.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;



//구현체 (동작)
@Repository
public class MemoryUserRepository implements UserRepository {

    //DB 도입 전에 간단한 구현을 위해 메모리 저장
    //스레드 세이프한 ConcurrentHashMap 사용
    private  final Map<Long, User> store = new ConcurrentHashMap<>();
    //스레드 세이프한 AtomicLong 사용
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public User savedUserKey(User user) {
        long id = sequence.incrementAndGet();
        user.setId(id);
        store.put(user.getId(),user);
        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return store.values().stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }

}
