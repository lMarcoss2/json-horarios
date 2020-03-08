package edu.calc.json.horarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HorariosApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HorariosApplication.class, args);
    }


}
