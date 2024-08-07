package reconnnect.kseb.kseb_open_acess;

import org.springframework.boot.SpringApplication;

public class TestKsebOpenAcessApplication {

	public static void main(String[] args) {
		SpringApplication.from(KsebOpenAcessApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
