package application;
import application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@SpringBootApplication
@ComponentScan
public class Application {

    public static final String DATE_FORMAT_STRING = "dd/MMM/YYYY";
    @Autowired
    private Repository repository;

    @Bean
    public Repository repositoryImpl() {
        return new Repository();
    }

    public static void main(String[] args)throws Throwable{
        SpringApplication.run(Application.class, args);
    }
}
