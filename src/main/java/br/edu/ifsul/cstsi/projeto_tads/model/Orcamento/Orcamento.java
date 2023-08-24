package br.edu.ifsul.cstsi.projeto_tads.model.Orcamento;


import br.edu.ifsul.cstsi.projeto_tads.model.ItensOrcamento.ItensOrcamento;
import br.edu.ifsul.cstsi.projeto_tads.model.Salao.Salao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orcamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Integer salaoId;
    private String nome;
    private String descricao;
    private BigDecimal valorTotal;
    private BigDecimal valorBase;


    @ManyToMany
    @JoinColumn(name = "salao_id", referencedColumnName = "id")
    private List<Salao> saloes;



//    @ManyToMany(mappedBy = "orcamentos")
//    @JoinColumn(name = "salao_id", referencedColumnName = "id")
//    private List<ItensOrcamento> itens;

    @ManyToMany(mappedBy = "orcamentos")
    private List<ItensOrcamento> itens;


}
