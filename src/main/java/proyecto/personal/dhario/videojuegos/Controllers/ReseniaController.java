package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.personal.dhario.videojuegos.Entities.Resenia;
import proyecto.personal.dhario.videojuegos.Repositories.ReseniaRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/resenias")
public class ReseniaController {

    @Autowired
    private ReseniaRepository reseniaRepository;

    @GetMapping
    public String getResenias(Model model) {
        List<Resenia> reseniasLista = reseniaRepository.findAll();
        model.addAttribute("resenias", reseniasLista);
        return "resenias"; // Nombre de la plantilla Thymeleaf para listar resenias
    }

    @GetMapping("/{id}")
    public String getReseniaById(Model model, @PathVariable Integer id) {
        Optional<Resenia> resenia = reseniaRepository.findById(id);
        if (resenia.isPresent()) {
            model.addAttribute("resenia", resenia.get());
        } else {
            model.addAttribute("error", "Reseña no encontrada");
        }
        return "detalleResenia"; // Nombre de la plantilla Thymeleaf para mostrar detalles de resenia
    }

    @GetMapping("/crear")
    public String crearReseniaForm(Model model) {
        model.addAttribute("resenia", new Resenia());
        return "crearResenia"; // Nombre de la plantilla Thymeleaf para crear una nueva resenia
    }

    @PostMapping("/crear")
    public String crearResenia(Resenia resenia) {
        reseniaRepository.save(resenia);
        return "redirect:/resenias";
    }

    @GetMapping("/editar/{id}")
    public String editarReseniaForm(Model model, @PathVariable Integer id) {
        Optional<Resenia> resenia = reseniaRepository.findById(id);
        if (resenia.isPresent()) {
            model.addAttribute("resenia", resenia.get());
            return "editarResenia"; // Nombre de la plantilla Thymeleaf para editar resenia
        } else {
            model.addAttribute("error", "Reseña no encontrada");
            return "redirect:/resenias";
        }
    }

    @PostMapping("/editar")
    public String editarResenia(Resenia resenia) {
        reseniaRepository.save(resenia);
        return "redirect:/resenias";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarResenia(@PathVariable Integer id) {
        reseniaRepository.deleteById(id);
        return "redirect:/resenias";
    }
}
