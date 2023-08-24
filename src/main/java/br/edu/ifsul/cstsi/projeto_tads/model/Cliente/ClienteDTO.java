package br.edu.ifsul.cstsi.projeto_tads.model.Cliente;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String email;
    private String telefone;
    private String fotoPerfil;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public static ClienteDTO create(Cliente p){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(p, ClienteDTO.class);
    }
}