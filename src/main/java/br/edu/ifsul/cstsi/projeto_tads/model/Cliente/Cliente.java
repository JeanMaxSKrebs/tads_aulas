package br.edu.ifsul.cstsi.projeto_tads.model.Cliente;

import br.edu.ifsul.cstsi.projeto_tads.model.Reserva.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "clientes")
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private Long cpf;
    private Integer idade;
    private String email;
    private Long telefone;
    private String fotoPerfil;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @OneToMany(mappedBy="cliente")
    private List<Reserva> reservas;
}
