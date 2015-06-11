package workshop.microservices.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import workshop.micorservices.config.ConfigServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConfigServiceApplication.class)
@WebAppConfiguration
public class ConfigServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
