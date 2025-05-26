package agenciaViagens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"agenciaViagens", "config", "service", "repository", "controller", "model"})
public class AgenciaViagensApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgenciaViagensApplication.class, args);
    }
}