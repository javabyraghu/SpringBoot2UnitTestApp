package in.nareshit.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot2UnitTestAppApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringBoot2UnitTestAppApplication.class, args);
		System.out.println(ac.getClass().getName());
	}

}
