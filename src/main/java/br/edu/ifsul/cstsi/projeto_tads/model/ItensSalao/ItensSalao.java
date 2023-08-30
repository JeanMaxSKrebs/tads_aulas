package br.edu.ifsul.cstsi.projeto_tads.model.ItensSalao;

import br.edu.ifsul.cstsi.projeto_tads.model.Cliente.Cliente;
import br.edu.ifsul.cstsi.projeto_tads.model.Item.Item;
import br.edu.ifsul.cstsi.projeto_tads.model.ItensOrcamento.ItensOrcamento;
import br.edu.ifsul.cstsi.projeto_tads.model.Orcamento.Orcamento;
import br.edu.ifsul.cstsi.projeto_tads.model.Salao.Salao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "itens_saloes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensSalao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private BigDecimal valorUnitario;
    private Integer quantidade;


    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "salao_id", referencedColumnName = "id", nullable = false)
    private Salao salao;

    @OneToMany(mappedBy="itensSaloes")
    private List<ItensOrcamento> itensOrcamentos;
}
