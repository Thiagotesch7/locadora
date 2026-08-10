package eventos.rental.controller;

import eventos.rental.model.equipamento;
import eventos.rental.service.equipamentoservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(
            EquipamentoService service
    ) {
        this.service = service;
    }

    @GetMapping
    public String listar(
            @RequestParam(required = false) String busca,
            Model model
    ) {

        if (busca == null || busca.isBlank()) {

            model.addAttribute(
                    "equipamentos",
                    service.listar()
            );

        } else {

            model.addAttribute(
                    "equipamentos",
                    service.pesquisar(busca)
            );
        }

        model.addAttribute("busca", busca);

        return "equipamentos/index";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute(
                "equipamento",
                new Equipamento()
        );

        return "equipamentos/form";
    }

    @PostMapping
    public String salvar(
            @ModelAttribute Equipamento equipamento
    ) {

        service.salvar(equipamento);

        return "redirect:/equipamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute(
                "equipamento",
                service.buscarPorId(id)
        );

        return "equipamentos/form";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(
            @PathVariable Long id
    ) {

        service.excluir(id);

        return "redirect:/equipamentos";
    }
}