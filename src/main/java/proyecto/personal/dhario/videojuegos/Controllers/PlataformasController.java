package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.personal.dhario.videojuegos.Entities.Plataformas;
import proyecto.personal.dhario.videojuegos.Repositories.PlataformasRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/plataformas")
public class PlataformasController {

    @Autowired
    private PlataformasRepository plataformasRepository;

    @GetMapping
    public String getPlataformas(Model model) {
        List<Plataformas> plataformasLista = plataformasRepository.findAll();
        model.addAttribute("plataformas", plataformasLista);
        return "plataformas"; // el nombre de tu plantilla Thymeleaf para listar plataformas
    }

    @GetMapping("/{id}")
    public String getPlataformasById(Model model, @PathVariable Integer id) {
        Optional<Plataformas> plataformas = plataformasRepository.findById(id);
        if (plataformas.isPresent()) {
            model.addAttribute("plataformas", plataformas.get());
        } else {
            model.addAttribute("error", "Plataformas no encontrado");
        }
        return "detallePlataformas"; // el nombre de tu plantilla Thymeleaf para mostrar detalles de plataformas
    }

    @GetMapping("/crear")
    public String crearPlataformasForm(Model model) {
        model.addAttribute("plataformas", new Plataformas());
        return "crearPlataformas"; // el nombre de tu plantilla Thymeleaf para crear plataformas
    }

    @PostMapping("/crear")
    public String crearPlataformas(Plataformas plataformas) {
        plataformasRepository.save(plataformas);
        return "redirect:/plataformas";
    }

    @GetMapping("/editar/{id}")
    public String editarPlataformasForm(Model model, @PathVariable Integer id) {
        Optional<Plataformas> plataformas = plataformasRepository.findById(id);
        if (plataformas.isPresent()) {
            model.addAttribute("plataformas", plataformas.get());
            return "editarPlataformas"; // el nombre de tu plantilla Thymeleaf para editar plataformas
        } else {
            model.addAttribute("error", "Plataformas no encontrado");
            return "redirect:/plataformas";
        }
    }

    @PostMapping("/editar")
    public String editarPlataformas(Plataformas plataformas) {
        plataformasRepository.save(plataformas);
        return "redirect:/plataformas";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPlataformas(@PathVariable Integer id) {
        plataformasRepository.deleteById(id);
        return "redirect:/plataformas";
    }
}
