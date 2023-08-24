package br.edu.ifsul.cstsi.projeto_tads.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository rep;

    public List<ClienteDTO> getClientes() {
        return rep.findAll()
                .stream() //1. Crie um fluxo para os meus dados
                .map(ClienteDTO::create) //2. Transforme Cliente em ClienteDTO
                .collect(Collectors.toList()); //3. Colete esse fluxo para uma coleção do tipo List
    }

    public ClienteDTO getClienteById(Long id) {
        Optional<Cliente> cliente = rep.findById(id);
        return cliente.map(ClienteDTO::create).orElse(null);
    }

    public List<ClienteDTO> getClientesByNome(String nome) {
        return rep.findByNome(nome+"%")
                .stream()
                .map(ClienteDTO::create)
                .collect(Collectors.toList());
    }

    public ClienteDTO insert(Cliente cliente) {
        Assert.isNull(cliente.getId(),"Não foi possível inserir o registro");
        return ClienteDTO.create(rep.save(cliente));
    }

    public ClienteDTO update(Cliente cliente, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o cliente no banco de dados
        Optional<Cliente> optional = rep.findById(id);
        if(optional.isPresent()) {
            Cliente db = optional.get();
            // Copia as propriedades
            db.setNome(cliente.getNome());
            db.setCpf(cliente.getCpf());
            db.setEmail(cliente.getEmail());
            db.setFotoPerfil(cliente.getFotoPerfil());
            db.setIdade(cliente.getIdade());
            db.setTelefone(cliente.getTelefone());
            db.setUpdatedAt(cliente.getUpdatedAt());
            db.setCreatedAt(cliente.getCreatedAt());

            System.out.println("Cliente id " + db.getId());

            // Atualiza o cliente
            rep.save(db);

            return ClienteDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public boolean delete(Long id) {
        Optional<Cliente> optional = rep.findById(id);
        if(optional.isPresent()) {
            rep.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}