package tr.com.nadir.redis;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	MessageRepository repo;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Collection<String> list() {
		return repo.list();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody MessageForm form) {
		repo.save(form.getContent());
	}
}

class MessageForm {
	String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
