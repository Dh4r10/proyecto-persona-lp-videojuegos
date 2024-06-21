package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.personal.dhario.videojuegos.Entities.Desarrolladora;
import proyecto.personal.dhario.videojuegos.Entities.Genero;
import proyecto.personal.dhario.videojuegos.Entities.Videojuegos;
import proyecto.personal.dhario.videojuegos.Repositories.DesarrolladoraRepository;
import proyecto.personal.dhario.videojuegos.Repositories.GeneroRepository;
import proyecto.personal.dhario.videojuegos.Repositories.VideojuegosRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class VideojuegosController {

    @Autowired
    private VideojuegosRepository videojuegosRepository;
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private DesarrolladoraRepository desarrolladoraRepository;

    @GetMapping
    public String getVideojuegos(Model model) {
        List<Videojuegos> videojuegosLista = videojuegosRepository.findAll();
        model.addAttribute("videojuegos", videojuegosLista);

        return "index";
    }

    @GetMapping("/videojuegos")
    public String videojuegosAdmin(Model model) {
        List<Videojuegos> videojuegosLista = videojuegosRepository.findAll();
        model.addAttribute("videojuegos", videojuegosLista);
        model.addAttribute("videojuegoForm", new Videojuegos());

        List<Genero> generosLista = generoRepository.findAll();
        model.addAttribute("generosSelect", generosLista);

        List<Desarrolladora> desarrolladorasLista = desarrolladoraRepository.findAll();
        model.addAttribute("desarrolladoraSelect", desarrolladorasLista);

        return "videojuegos";
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

    @PostMapping("/videojuegos-create")
    public String crearVideojuego(Videojuegos videojuego) {
        videojuego.setEstado(true);
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

    @RequestMapping("/eliminar-videojuego/{id}")
    public String eliminarVideojuego(@PathVariable Integer id) {
        videojuegosRepository.deleteById(id);
        return "redirect:/videojuegos";
    }
}

