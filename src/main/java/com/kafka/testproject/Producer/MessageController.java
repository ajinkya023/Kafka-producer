package com.kafka.testproject.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {

	/** The kafka template. */
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/** The Constant TOPIC. */
	private static final String TOPIC = "Ajinkya";

	/**
	 * Post.
	 *
	 * @param data the data
	 * @return the string
	 */
	@GetMapping("/sendData/{data}")
	public String post(@PathVariable("data") final String data) {

		kafkaTemplate.send(TOPIC, data);

		return "Published successfully";
	}
}