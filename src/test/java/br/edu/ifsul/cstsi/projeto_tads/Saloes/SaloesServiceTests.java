package br.edu.ifsul.cstsi.projeto_tads.Saloes;

import br.edu.ifsul.cstsi.projeto_tads.ProjetoTadsApplication;
import br.edu.ifsul.cstsi.projeto_tads.api.infra.exception.ObjectNotFoundException;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Salao.Salao;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Salao.SalaoDTO;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Salao.SalaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static junit.framework.TestCase.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProjetoTadsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaloesServiceTests {

    @Autowired
    private SalaoService service;
    @Test
    public void testGetSaloes() {
        List<SalaoDTO> saloes = service.getSaloes();
        if (saloes.size() < 3) {
            // Se a lista tiver menos de 3 registros, o teste falhará.
            fail("Esperado ao menos 3 registros, mas encontrado " + saloes.size());
        }
    }


    @Test
    public void testEmpty() {
    }

    @Test
    public void testGetSaloesById(){
        SalaoDTO s = service.getSalaoById(1L);
        assertNotNull(s);
        assertEquals("Teste", s.getNome());
    }

    @Test
    public void getSaloesByNome(){
        assertEquals(1, service.getSaloesByNome("Teste").size());
    }

    @Test
    public void testInsert() {

        //cria o produto para teste
        Salao salao = new Salao();
        salao.setNome("Teste");
        salao.setDescricao("Desc. do salão Teste");
        salao.setEmail("teste@gmail.com");
        salao.setCapacidade(100);
        salao.setCnpj("12345678901234"); // Defina um número de CNPJ válido de 14 dígitos.
        salao.setEndereco("Endereço do Salão");
        salao.setCidade("Nome da Cidade");
        salao.setLogo("Caminho/Logo.png");
        salao.setImagens("['Caminho/Imagem1.png', 'Caminho/Imagem2.png']");
        salao.setCreatedAt(new Timestamp(System.currentTimeMillis())); // Defina a data/hora de criação atual.
        salao.setUpdatedAt(new Timestamp(System.currentTimeMillis())); // Defina a data/hora de atualização atual.

        //insere o produto na base da dados
        SalaoDTO s = service.insert(salao);

        //se inseriu
        assertNotNull(s);

        //confirma se o salao foi realmente inserido na base de dados
        Long id = s.getId();
        assertNotNull(id);
        s = service.getSalaoById(id);
        assertNotNull(s);

        // Compara os valores inseridos com os valores pesquisados para confirmar
        assertEquals("Teste", salao.getNome());
        assertEquals("Desc. do salão Teste", salao.getDescricao());
        assertEquals("teste@gmail.com", salao.getEmail());
        assertEquals(Integer.valueOf(100), salao.getCapacidade());
        assertEquals("12345678901234", salao.getCnpj());
        assertEquals("Endereço do Salão", salao.getEndereco());
        assertEquals("Nome da Cidade", salao.getCidade());
        assertEquals("Caminho/Logo.png", salao.getLogo());
        assertEquals("['Caminho/Imagem1.png', 'Caminho/Imagem2.png']", salao.getImagens());

        // Para as timestamps, você pode verificar se elas não são nulas
        // (não podemos prever os valores exatos, pois dependem do momento
        // em que o objeto é criado/atualizado).
        assertNotNull(salao.getCreatedAt());
        assertNotNull(salao.getUpdatedAt());

        // Deletar o objeto
        service.delete(id);
        //Verificar se deletou
        if(service.getSalaoById(id) != null){
            fail("O Salão não foi excluído");
        }
    }

    @Test
    public void testUpdate() {
        SalaoDTO sDTO = service.getSalaoById(1l);
        String nome = sDTO.getNome();
        sDTO.setNome("Teste modificado");

        ModelMapper modelMapper = new ModelMapper();
        Salao salao = modelMapper.map(sDTO, Salao.class);
        salao.setNome("Teste modificado");

        sDTO = service.update(salao, salao.getId());
        assertNotNull(sDTO);
        assertEquals("Teste modificado", sDTO.getNome());

        salao.setNome(nome); // Restaure o nome original do Salao.
        sDTO = service.update(salao, salao.getId()); // Atualize novamente, restaurando o nome original.
        assertNotNull(sDTO);
    }


    @Test
    public void testDelete(){
        //cria o produto para teste
        Salao salao = new Salao();
        salao.setNome("Teste");
        salao.setDescricao("Desc. do salão Teste");
        salao.setEmail("teste@gmail.com");
        salao.setCapacidade(100);
        salao.setCnpj("12345678901234"); // Defina um número de CNPJ válido de 14 dígitos.        salao.setEndereco("Endereço do Salão");
        salao.setCidade("Nome da Cidade");
        salao.setLogo("Caminho/Logo.png");
        salao.setImagens("['Caminho/Imagem1.png', 'Caminho/Imagem2.png']");
        salao.setCreatedAt(new Timestamp(System.currentTimeMillis())); // Defina a data/hora de criação atual.
        salao.setUpdatedAt(new Timestamp(System.currentTimeMillis())); // Defina a data/hora de atualização atual.


        //insere o produto na base da dados
        SalaoDTO s = service.insert(salao);

        //se inseriu
        assertNotNull(s);

        //confirma se o produto foi realmente inserido na base de dados
        Long id = s.getId();
        assertNotNull(id);
        s = service.getSalaoById(id);
        assertNotNull(s);

        // Deletar o objeto
        service.delete(id);
        //Verificar se deletou
        if(service.getSalaoById(id) != null){
            fail("O jogador não foi excluído");
        }
    }
}
