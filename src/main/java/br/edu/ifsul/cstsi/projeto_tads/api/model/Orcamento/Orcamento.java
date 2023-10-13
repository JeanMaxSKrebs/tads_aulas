package br.edu.ifsul.cstsi.projeto_tads.api.model.Orcamento;


import br.edu.ifsul.cstsi.projeto_tads.api.model.Salao.Salao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orcamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valorBase;
    private BigDecimal valorItens;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "salao_id", referencedColumnName = "id", nullable = false)
    private Salao salao;

}
