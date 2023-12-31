package br.edu.ifsul.cstsi.projeto_tads.api.model.Item;

import br.edu.ifsul.cstsi.projeto_tads.api.model.ItensSalao.ItensSalao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "itens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy="item")
    private List<ItensSalao> itensSaloes;
}
