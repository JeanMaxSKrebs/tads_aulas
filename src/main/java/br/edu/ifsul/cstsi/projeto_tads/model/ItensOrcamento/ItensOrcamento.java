package br.edu.ifsul.cstsi.projeto_tads.model.ItensOrcamento;

import br.edu.ifsul.cstsi.projeto_tads.model.Cliente.Cliente;
import br.edu.ifsul.cstsi.projeto_tads.model.ItensSalao.ItensSalao;
import br.edu.ifsul.cstsi.projeto_tads.model.Orcamento.Orcamento;
import br.edu.ifsul.cstsi.projeto_tads.model.Salao.Salao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
