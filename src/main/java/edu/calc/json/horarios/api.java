package edu.calc.json.horarios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 08/03/20
 */
@RequestMapping("/")
public class api {
    @GetMapping
    public String getSwagger(){
        return "/docs/swagger-ui.html";
    }
}
