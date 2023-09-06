
package br.edu.ifsul.cstsi.projeto_tads.model.Salao;

import br.edu.ifsul.cstsi.projeto_tads.model.Cliente.Cliente;
import br.edu.ifsul.cstsi.projeto_tads.model.Cliente.ClienteDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
public class SalaoDTO {
    private Long id;
    private String nome;
    private Long cnpj;
    private String endereco;
    private String cidade;
    private String descricao;
    private Integer capacidade;
    private String logo;
    private String imagens;
//    private String mensagens;
//    private Timestamp createdAt;
//    private Timestamp updatedAt;
    private String email;

    public static SalaoDTO create(Salao s){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(s, SalaoDTO.class);
    }
}