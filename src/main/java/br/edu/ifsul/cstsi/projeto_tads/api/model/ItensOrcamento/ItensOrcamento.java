package br.edu.ifsul.cstsi.projeto_tads.api.model.ItensOrcamento;

import br.edu.ifsul.cstsi.projeto_tads.api.model.ItensSalao.ItensSalao;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Orcamento.Orcamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_orcamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensOrcamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private BigDecimal valorUnitario;
    private Integer quantidade;

//    @ManyToMany(fetch = FetchType.EAGER)


//    @ManyToMany
//    @JoinTable(joinColumns = @JoinColumn(name = "orcamentos_id", referencedColumnName = "id"))
//    private List<Orcamento> orcamentos;

//    @ManyToMany
//    @JoinColumn(name = "orcamento_id", referencedColumnName = "id")
//    private List<Orcamento> orcamento;

    @ManyToOne
    @JoinColumn(name = "orcamento_id", referencedColumnName = "id", nullable = false)
    private Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "itens_saloes_id", referencedColumnName = "id", nullable = false)
    private ItensSalao itensSaloes;

}
