package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.personal.dhario.videojuegos.Entities.Genero;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login() {
        return "login";
    }
}
