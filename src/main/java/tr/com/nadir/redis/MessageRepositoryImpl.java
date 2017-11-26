package tr.com.nadir.redis;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository {
	private static final String KEY = "message";

	@Autowired
	RedisTemplate<String, String> redis;
	ListOperations<String, String> ops;

	@PostConstruct
	private void init() {
		ops = redis.opsForList();
	}

	@Override
	public void save(String message) {
		ops.leftPush(KEY, message);
	}

	@Override
	public List<String> list() {
		return ops.range(KEY, 0, ops.size(KEY));
	}

}
