package br.edu.ifsul.cstsi.projeto_tads.api.model.Salao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/saloes")
public class SalaoController {

    @Autowired
    private SalaoService service;


    @GetMapping //api/v1/saloes
    public ResponseEntity<List<SalaoDTO>> selectAll() {
        return ResponseEntity.ok(service.getSaloes());
    }

    @GetMapping("{id}") //api/v1/saloes/1
    public ResponseEntity<SalaoDTO> selectById(@PathVariable("id") Long id) {
        SalaoDTO p = service.getSalaoById(id);
        return p != null ?
                ResponseEntity.ok(p) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/nome/{nome}") //api/v1/saloes/nome/fernando
    public ResponseEntity<List<SalaoDTO>> selectByName(@PathVariable("nome") String nome) {
        List<SalaoDTO> saloes = service.getSaloesByNome(nome);
        return saloes.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(saloes);
    }


    @PostMapping("/cadastro") //api/v1/saloes/cadastro
    public ResponseEntity<String> insert(@RequestBody Salao salao){
        SalaoDTO c = service.insert(salao);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}") //api/v1/saloes/1
    public ResponseEntity<SalaoDTO> update(@PathVariable("id") Long id, @RequestBody Salao salao){
        salao.setId(id);
        SalaoDTO c = service.update(salao, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }
    @Secured({"ROLE_ADMIN"})

    @DeleteMapping("{id}") //api/v1/saloes/1
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return service.delete(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }


    //utilitário
    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }
}
