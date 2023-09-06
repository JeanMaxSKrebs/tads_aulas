package br.edu.ifsul.cstsi.projeto_tads.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Query(value = "SELECT c FROM clientes c where c.nome like ?1")
    List<Cliente> findByNome(String nome);
}