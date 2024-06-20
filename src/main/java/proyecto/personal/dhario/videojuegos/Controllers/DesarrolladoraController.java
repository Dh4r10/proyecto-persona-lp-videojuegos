package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.personal.dhario.videojuegos.Entities.Desarrolladora;
import proyecto.personal.dhario.videojuegos.Repositories.DesarrolladoraRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/desarrolladora")
public class DesarrolladoraController {

    @Autowired
    private DesarrolladoraRepository desarrolladoraRepository;

    @GetMapping
    public String getDesarrolladora(Model model) {
        List<Desarrolladora> desarrolladoraLista = desarrolladoraRepository.findAll();
        model.addAttribute("desarrolladora", desarrolladoraLista);
        return "videojuegos";
    }

    @GetMapping("/{id}")
    public String getDesarrolladoraById(Model model, @PathVariable Integer id) {
        Optional<Desarrolladora> desarrolladora = desarrolladoraRepository.findById(id);
        if (desarrolladora.isPresent()) {
            model.addAttribute("desarrolladora", desarrolladora.get());
        } else {
            model.addAttribute("error", "Desarrolladora no encontrada");
        }
        return "detalleDesarrolladora";
    }

    @PostMapping("/crear")
    public String crearDesarrolladora(Desarrolladora desarrolladora) {
        desarrolladoraRepository.save(desarrolladora);
        return "redirect:/desarrolladora";
    }

    @GetMapping("/editar/{id}")
    public String editarDesarrolladoraForm(Model model, @PathVariable Integer id) {
        Optional<Desarrolladora> desarrolladora = desarrolladoraRepository.findById(id);
        if (desarrolladora.isPresent()) {
            model.addAttribute("desarrolladora", desarrolladora.get());
            return "editarDesarrolladora";
        } else {
            model.addAttribute("error", "Desarrolladora no encontrada");
            return "redirect:/desarrolladora";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarDesarrolladora(@PathVariable Integer id) {
        desarrolladoraRepository.deleteById(id);
        return "redirect:/desarrolladora";
    }

}
