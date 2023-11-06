package br.edu.ifsul.cstsi.projeto_tads.api.model.Cliente;

import br.edu.ifsul.cstsi.projeto_tads.api.model.Reserva.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @NotNull(message = "O CPF não pode ser nulo.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos.")
    private Long cpf;

    @Min(value = 18, message = "A idade mínima é de 18 anos.")
    private Integer idade;

    @Email(message = "O email deve ser válido.")
    private String email;

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos numéricos.")
    private Long telefone;

    private String fotoPerfil;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToMany(mappedBy="cliente")
    private List<Reserva> reservas;
}
