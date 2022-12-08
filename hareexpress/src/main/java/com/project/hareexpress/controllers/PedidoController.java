package com.project.hareexpress.controllers;


import com.project.hareexpress.domain.models.Pedido;
import com.project.hareexpress.domain.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;


    @PostMapping("/create")
    public ModelAndView create(@Valid Pedido pedido) {

        ModelAndView mv = new ModelAndView();

        Integer etapa = pedido.getEtapa();
        if (Objects.nonNull(etapa)) {
            switch (etapa) {

                case 1:
                    pedido.setEtapa(2);
                    mv.setViewName("/cliente/solicitar_entrega2");
                    mv.addObject("pedido", pedido);
                    break;

                case 2:
                    pedido.setEtapa(3);
                    mv.setViewName("/cliente/solicitar_entrega3");
                    mv.addObject("pedido", pedido);
                    break;


                case 3:

                    if (Objects.nonNull(pedidoRepository.save(pedido))) {

                        mv.setViewName("/cliente/detalhes_entrega");
                        mv.addObject("pedido", pedido);

                    } else {
                        mv.setViewName("cliente/solicitar_entrega3");
                        mv.addObject("error", "Algo deu errado ao salvar as informações, tente novamente!");
                        mv.addObject("pedido", pedido);
                    }
                    break;

            }
        }

        return mv;
    }
}