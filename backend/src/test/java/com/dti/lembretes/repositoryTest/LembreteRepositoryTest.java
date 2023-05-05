package com.dti.lembretes.repositoryTest;

import com.dti.lembretes.repository.LembreteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class LembreteRepositoryTest {

    @MockBean
    private LembreteRepository lembreteRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    @DisplayName("Testa se um lembrete é criado")
    void testCriaLembrete() {


    }

}
