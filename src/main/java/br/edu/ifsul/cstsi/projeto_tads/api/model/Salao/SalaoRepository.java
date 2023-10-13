package br.edu.ifsul.cstsi.projeto_tads.api.model.Salao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaoRepository extends JpaRepository<Salao,Long> {
    @Query(value = "SELECT p FROM saloes p where p.nome like ?1")
    List<Salao> findByNome(String nome);
}