package foro.hub.apiForoHub.controller;

import foro.hub.apiForoHub.topico.DatosRegistrarTopico;
import foro.hub.apiForoHub.topico.Topico;
import foro.hub.apiForoHub.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody DatosRegistrarTopico datosRegistrarTopico){
        topicoRepository.save(new Topico(datosRegistrarTopico));
    }
}
