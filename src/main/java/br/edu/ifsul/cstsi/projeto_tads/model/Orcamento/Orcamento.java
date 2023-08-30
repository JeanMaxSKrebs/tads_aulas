package br.edu.ifsul.cstsi.projeto_tads.model.Orcamento;


import br.edu.ifsul.cstsi.projeto_tads.model.ItensOrcamento.ItensOrcamento;
import br.edu.ifsul.cstsi.projeto_tads.model.Reserva.Reserva;
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
    private String nome;
    private String descricao;
    private BigDecimal valorBase;
    private BigDecimal valorItens;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "salao_id", referencedColumnName = "id", nullable = false)
    private Salao salao;

}
