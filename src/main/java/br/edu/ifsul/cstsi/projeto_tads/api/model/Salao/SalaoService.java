package br.edu.ifsul.cstsi.projeto_tads.api.model.Salao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaoService {

    @Autowired
    private SalaoRepository rep;

    public List<SalaoDTO> getSaloes() {
        return rep.findAll()
                .stream() //1. Crie um fluxo para os meus dados
                .map(SalaoDTO::create) //2. Transforme Salao em SalaoDTO
                .collect(Collectors.toList()); //3. Colete esse fluxo para uma coleção do tipo List
    }

    public SalaoDTO getSalaoById(Long id) {
        Optional<Salao> salao = rep.findById(id);
        return salao.map(SalaoDTO::create).orElse(null);
    }

    public List<SalaoDTO> getSaloesByNome(String nome) {
        return rep.findByNome(nome+"%")
                .stream()
                .map(SalaoDTO::create)
                .collect(Collectors.toList());
    }

    public SalaoDTO insert(Salao salao) {
        Assert.isNull(salao.getId(),"Não foi possível inserir o registro");
        return SalaoDTO.create(rep.save(salao));
    }

    public SalaoDTO update(Salao salao, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o salao no banco de dados
        Optional<Salao> optional = rep.findById(id);
        if(optional.isPresent()) {
            Salao db = optional.get();
            // Copia as propriedades
            db.setNome(salao.getNome());
            db.setCnpj(salao.getCnpj());
            db.setEmail(salao.getEmail());
            db.setLogo(salao.getLogo());
            db.setCidade(salao.getCidade());
            db.setCapacidade(salao.getCapacidade());
            db.setEndereco(salao.getEndereco());
            db.setDescricao(salao.getDescricao());
            db.setImagens(salao.getImagens());
            db.setMensagens(salao.getMensagens());
            db.setUpdatedAt(salao.getUpdatedAt());
            db.setCreatedAt(salao.getCreatedAt());

            System.out.println("Salao id " + db.getId());

            // Atualiza o salao
            rep.save(db);

            return SalaoDTO.create(db);
        } else {
            return null;
//            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public boolean delete(Long id) {
        Optional<Salao> optional = rep.findById(id);
        if(optional.isPresent()) {
            rep.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
