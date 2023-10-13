package br.edu.ifsul.cstsi.projeto_tads.api.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping //api/v1/clientes
    public ResponseEntity<List<ClienteDTO>> selectAll() {
        return ResponseEntity.ok(service.getClientes());
    }

    @GetMapping("{id}") //api/v1/clientes/1
    public ResponseEntity<ClienteDTO> selectById(@PathVariable("id") Long id) {
        ClienteDTO p = service.getClienteById(id);
        return p != null ?
                ResponseEntity.ok(p) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/nome/{nome}") //api/v1/clientes/nome/fernando
    public ResponseEntity<List<ClienteDTO>> selectByName(@PathVariable("nome") String nome) {
        List<ClienteDTO> clientes = service.getClientesByNome(nome);
        return clientes.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(clientes);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping //api/v1/clientes
    public ResponseEntity<String> insert(@RequestBody Cliente cliente){
        ClienteDTO c = service.insert(cliente);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}") //api/v1/clientes/1
    public ResponseEntity<ClienteDTO> update(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        ClienteDTO c = service.update(cliente, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}") //api/v1/clientes/1
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