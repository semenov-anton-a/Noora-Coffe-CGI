package noora.coffe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ModelAttribute;


@SpringBootApplication
public class CoffeApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(CoffeApplication.class, args);
	}



	public static String getAppVersion(){
		return "1.510";
	}

}
