package br.edu.ifsul.cstsi.projeto_tads.Saloes;

import br.edu.ifsul.cstsi.projeto_tads.ProjetoTadsApplication;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Salao.Salao;
import br.edu.ifsul.cstsi.projeto_tads.api.model.Salao.SalaoDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProjetoTadsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SaloesControllerTests extends BaseAPITest {

    private ResponseEntity<SalaoDTO> getSalao(String url) {
        return get(url, SalaoDTO.class);
    }

    private ResponseEntity<List<SalaoDTO>> getSaloes(String url) {
        HttpHeaders headers = getHeaders();

        return rest.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<SalaoDTO>>() {}
        );
    }

    @Test
    void selectAll() {
        List<SalaoDTO> saloes = getSaloes("/api/v1/saloes").getBody();
        assertNotNull(saloes);
        assertEquals(3, saloes.size());
    }

    @Test
    void selectById() {

        assertNotNull(getSalao("/api/v1/saloes/1"));
        assertNotNull(getSalao("/api/v1/saloes/2"));

        assertEquals(HttpStatus.NOT_FOUND, getSalao("/api/v1/saloes/1000").getStatusCode());
    }


    @Test
    void insert() {
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


        ResponseEntity response = post("/api/v1/saloes/cadastro", salao, null);
//        System.out.println("response:");
//        System.out.println(response);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        String location = response.getHeaders().get("location").get(0);
//        System.out.println("location:");
//        System.out.println(location);
        location = location.replace("/cadastro/", "/");
        System.out.println(location);
//        System.out.println("location:");
//        System.out.println(location);
        SalaoDTO s = getSalao(location).getBody();


        assertNotNull(s);
//        System.out.println("s.getNome():");
//        System.out.println(s.getNome());
//        System.out.println(s);

        assertEquals("Teste", s.getNome());

        delete(location, null);

        assertEquals(HttpStatus.NOT_FOUND, getSalao(location).getStatusCode());
    }

    @Test
    void update() {
        //cria o produto para teste
        Salao salao = new Salao();
        salao.setNome("Teste Modificado");
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

        ResponseEntity<Object> response = post("/api/v1/saloes/cadastro", salao, null);
        System.out.println("post response:");
        System.out.println(response);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());


        String location = response.getHeaders().get("location").get(0);
//        System.out.println("location:");
//        System.out.println(location);
        location = location.replace("/cadastro/", "/");
        System.out.println(location);
//        System.out.println("location:");
//        System.out.println(location);
        SalaoDTO s = getSalao(location).getBody();


        Salao salaoPut = new Salao();
        salaoPut.setNome("Teste Modificado put");


        response = put("/api/v1/saloes/" + s.getId(), salaoPut, null);
        System.out.println("put response");
        System.out.println(response);
        assertEquals("Teste Modificado put", salaoPut.getNome());

        delete(location, null);

        assertEquals(HttpStatus.NOT_FOUND, getSalao(location).getStatusCode());
    }

    @Test
    void delete() {
    }
}