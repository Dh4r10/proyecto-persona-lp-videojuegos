package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.personal.dhario.videojuegos.Entities.Genero;
import proyecto.personal.dhario.videojuegos.Repositories.GeneroRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public String getGeneros(Model model) {
        List<Genero> generoLista = generoRepository.findAll();
        model.addAttribute("generos", generoLista);
        return "generos"; // el nombre de tu plantilla Thymeleaf para listar generos
    }

    @GetMapping("/{id}")
    public String getGeneroById(Model model, @PathVariable Integer id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()) {
            model.addAttribute("genero", genero.get());
        } else {
            model.addAttribute("error", "Género no encontrado");
        }
        return "detalleGenero"; // el nombre de tu plantilla Thymeleaf para mostrar detalles de genero
    }

    @PostMapping("/crear")
    public String crearGenero(Genero genero) {
        generoRepository.save(genero);
        return "redirect:/genero";
    }

    @GetMapping("/editar/{id}")
    public String editarGeneroForm(Model model, @PathVariable Integer id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()) {
            model.addAttribute("genero", genero.get());
            return "editarGenero"; // el nombre de tu plantilla Thymeleaf para editar genero
        } else {
            model.addAttribute("error", "Género no encontrado");
            return "redirect:/genero";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarGenero(@PathVariable Integer id) {
        generoRepository.deleteById(id);
        return "redirect:/genero";
    }
}