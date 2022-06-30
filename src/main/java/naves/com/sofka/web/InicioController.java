package naves.com.sofka.web;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import naves.com.sofka.domain.Nave;
import naves.com.sofka.servicio.NaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class InicioController {

    @Autowired
    private NaveService naveService;
   
    @GetMapping("/")
    public String inicio(Model model, @Param("palabraClave") String palabraClave){

        var naves = naveService.listarNaves(palabraClave);
        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("naves", naves);
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Nave nave){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Nave nave){
        naveService.guardar(nave);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id_nave}")
    public String editar(Nave nave, Model model){
        nave = naveService.buscar(nave);
        model.addAttribute("nave", nave);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id_nave}")
    public String eliminar (Nave nave){
        naveService.eliminar(nave);
        return "redirect:/";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam String nombre_nave, Model model, @ModelAttribute("nave") Nave nave){
        nave = naveService.buscar(nave);
        model.addAttribute("nombre_nave", naveService.buscar(nave));
        return "redirect:/";
    }
            
}
