package br.edu.ifsul.cstsi.projeto_tads.model.ItensOrcamento;

import br.edu.ifsul.cstsi.projeto_tads.model.Orcamento.Orcamento;
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
    private String nome;
    private BigDecimal valorUnitario;
    private Integer quantidade;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "orcamento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Orcamento> orcamentos;

}
