package br.edu.ifsul.cstsi.projeto_tads.model.Salao;

import br.edu.ifsul.cstsi.projeto_tads.model.Orcamento.Orcamento;
import br.edu.ifsul.cstsi.projeto_tads.model.Reserva.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "saloes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private Long cnpj;
    private String endereco;
    private String cidade;
    private String descricao;
    private Integer capacidade;
    private String logo;
    private String imagens;
    private String mensagens;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String email;

    @OneToMany(mappedBy="salao")
    private List<Reserva> reservas;

    @ManyToMany(mappedBy="saloes")
    private List<Orcamento> orcamentos;

}
