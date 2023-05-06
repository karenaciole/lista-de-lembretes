package com.dti.lembretes.repositoryTest;

import com.dti.lembretes.model.Lembrete;
import com.dti.lembretes.repository.LembreteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LembreteRepositoryTest {

    private LembreteRepository lembreteRepository;

    @BeforeEach
    public void setUp() {
        this.lembreteRepository = new LembreteRepository();
    }

    @Test
    @DisplayName("Testa se um lembrete é adicionado ao repositório")
    void testCriaLembrete() {
        // Arrange
        String nomeDoLembrete = "Lembrete de teste";
        String data = "22/08/2023";
        Date dataDoLembreteFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data, new java.text.ParsePosition(0));
        Lembrete lembrete = new Lembrete(nomeDoLembrete, dataDoLembreteFormatada);

        // Act
        this.lembreteRepository.criaLembrete(lembrete);

       // Assert
       assertNotNull(lembrete.getId());
       assertEquals(lembrete.getNomeDoLembrete(), nomeDoLembrete);
       assertEquals(lembrete.getDataDoLembrete(), dataDoLembreteFormatada);

       assertEquals(1, this.lembreteRepository.getAll().size());
    }

    @Test
    @DisplayName("Testa se um outro lembrete é adicionado ao repositório")
    void testCriaLembrete2() {
        // Arrange
        String nomeDoLembrete = "Ir ao mercado";
        String data = "01/06/2023";
        Date dataDoLembreteFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data, new java.text.ParsePosition(0));
        Lembrete lembrete = new Lembrete(nomeDoLembrete, dataDoLembreteFormatada);

        // Act
        this.lembreteRepository.criaLembrete(lembrete);

        // Assert
        assertNotNull(lembrete.getId());
        assertEquals(lembrete.getNomeDoLembrete(), nomeDoLembrete);
        assertEquals(lembrete.getDataDoLembrete(), dataDoLembreteFormatada);
    }


    @Test
    @DisplayName("Testa se um lembrete é deletado do repositório")
    void testDeletaLembrete() {
        // Arrange
        String nomeDoLembrete = "Lembrete de teste";
        String data = "22/08/2023";
        Date dataDoLembreteFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data, new java.text.ParsePosition(0));
        Lembrete lembrete = new Lembrete(nomeDoLembrete, dataDoLembreteFormatada);

        // Act
        this.lembreteRepository.criaLembrete(lembrete);
        this.lembreteRepository.deletaLembrete(lembrete.getId());

        // Assert
        assertEquals(0, this.lembreteRepository.getAll().size());
    }

    @Test
    @DisplayName("Testa se um lembrete existe no repositório")
    void testLembreteExiste() {
        // Arrange
        String nomeDoLembrete = "Ir para praia";
        String data = "22/08/2023";
        Date dataDoLembreteFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data, new java.text.ParsePosition(0));
        Lembrete lembrete = new Lembrete(nomeDoLembrete, dataDoLembreteFormatada);

        // Act
        this.lembreteRepository.criaLembrete(lembrete);

        // Assert
        assertTrue(this.lembreteRepository.lembreteExiste(lembrete.getId()));
    }

    @Test
    @DisplayName("Testa se um lembrete não existe no repositório")
    void testLembreteNaoExiste() {
        // Arrange
        String nomeDoLembrete = "Levar o lixo para fora";
        String data = "11/06/2023";
        Date dataDoLembreteFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data, new java.text.ParsePosition(0));
        Lembrete lembrete = new Lembrete(nomeDoLembrete, dataDoLembreteFormatada);

        // Act
        this.lembreteRepository.criaLembrete(lembrete);

        // Assert
        assertFalse(this.lembreteRepository.lembreteExiste("12z-45a26-gk17-89"));
    }

}
