package br.edu.ifsul.cstsi.projeto_tads.model.Reserva;

import br.edu.ifsul.cstsi.projeto_tads.model.Cliente.Cliente;
import br.edu.ifsul.cstsi.projeto_tads.model.Salao.Salao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Timestamp dataHora;
    private BigDecimal valor;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "salao_id", referencedColumnName = "id", nullable = false)
    private Salao salao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

}
