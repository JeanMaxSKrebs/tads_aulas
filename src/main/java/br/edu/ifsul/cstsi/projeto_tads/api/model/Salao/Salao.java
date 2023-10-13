package br.edu.ifsul.cstsi.projeto_tads.api.model.Salao;

import br.edu.ifsul.cstsi.projeto_tads.api.model.ItensSalao.ItensSalao;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Orcamento.Orcamento;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Reserva.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "saloes")
@Table(name = "saloes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "O CNPJ não pode ser nulo ou vazio")
    @Size(min = 14, max = 14 , message = "O CNPJ deve ter 14 digitos")
    private Long cnpj;
    private String endereco;
    private String cidade;
    private String descricao;
    @NotNull
    @Min(50)
    private Integer capacidade;
    private String logo;
    private String imagens;
    private String mensagens;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @NotBlank(message = "O email não pode ser nulo ou vazio")
    private String email;

    @OneToMany(mappedBy="salao")
    private List<Reserva> reservas;

    @OneToMany(mappedBy="salao")
    private List<Orcamento> orcamentos;

    @OneToMany(mappedBy="salao")
    private List<ItensSalao> itensSaloes;
}
