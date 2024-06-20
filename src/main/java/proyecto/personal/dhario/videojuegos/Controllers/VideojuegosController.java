package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.personal.dhario.videojuegos.Entities.Videojuegos;
import proyecto.personal.dhario.videojuegos.Repositories.VideojuegosRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class VideojuegosController {

    @Autowired
    private VideojuegosRepository videojuegosRepository;

    @GetMapping
    public String getVideojuegos(Model model) {
        List<Videojuegos> videojuegosLista = videojuegosRepository.findAll();
        model.addAttribute("videojuegos", videojuegosLista);
        return "index";
    }

    @GetMapping("/{id}")
    public String getVideojuegosById(Model model, @PathVariable Integer id) {
        Optional<Videojuegos> videojuegos = videojuegosRepository.findById(id);
        if (videojuegos.isPresent()) {
            model.addAttribute("videojuego", videojuegos.get());
        } else {
            model.addAttribute("error", "Videojuego no encontrado");
        }
        return "detalleVideojuego"; // Nombre de la plantilla Thymeleaf para mostrar detalles de videojuego
    }

    @GetMapping("/crear")
    public String crearVideojuegoForm(Model model) {
        model.addAttribute("videojuego", new Videojuegos());
        return "crearVideojuego"; // Nombre de la plantilla Thymeleaf para crear un nuevo videojuego
    }

    @PostMapping("/crear")
    public String crearVideojuego(Videojuegos videojuego) {
        videojuegosRepository.save(videojuego);
        return "redirect:/videojuegos";
    }

    @GetMapping("/editar/{id}")
    public String editarVideojuegoForm(Model model, @PathVariable Integer id) {
        Optional<Videojuegos> videojuego = videojuegosRepository.findById(id);
        if (videojuego.isPresent()) {
            model.addAttribute("videojuego", videojuego.get());
            return "editarVideojuego"; // Nombre de la plantilla Thymeleaf para editar videojuego
        } else {
            model.addAttribute("error", "Videojuego no encontrado");
            return "redirect:/videojuegos";
        }
    }

    @PostMapping("/editar")
    public String editarVideojuego(Videojuegos videojuego) {
        videojuegosRepository.save(videojuego);
        return "redirect:/videojuegos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarVideojuego(@PathVariable Integer id) {
        videojuegosRepository.deleteById(id);
        return "redirect:/videojuegos";
    }
}

