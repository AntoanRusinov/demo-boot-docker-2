package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@RequestMapping(value = "/docker2")
public class ApplicationTwo {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTwo.class, args);
	}

	@RequestMapping(value = "/hello")
	public String welcome() {
		return "You called app 2";
	}

	@RequestMapping(value = "/call-2-to-1")
	public ResponseEntity<?> callTheOtherApp() {

		final String url = "http://localhost:8080/docker1/hello";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);

		System.out.println(result);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}