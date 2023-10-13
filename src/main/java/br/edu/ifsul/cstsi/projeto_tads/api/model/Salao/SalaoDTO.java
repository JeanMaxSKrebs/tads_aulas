
package br.edu.ifsul.cstsi.projeto_tads.api.model.Salao;

import lombok.Data;
import org.modelmapper.ModelMapper;


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