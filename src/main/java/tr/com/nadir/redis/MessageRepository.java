package tr.com.nadir.redis;

import java.util.List;

public interface MessageRepository {
	public void save(String message);
	public List<String> list();
}
