package com.richardcsantana;

import com.richardcsantana.model.Dado;
import com.richardcsantana.repository.DadoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditSampleApplicationTests {

    @Autowired
    private DadoRepository dadoRepository;

    @Test
    public void saveData() throws Exception {
        Dado teste = dadoRepository.save(new Dado("teste"));
        dadoRepository.findById(teste.getId()).ifPresent(
                it -> {
                    assertThat(it.getCreatedDateTime()).isNotNull();
                    assertThat(it.getModifiedDateTime()).isNotNull();
                    assertThat(it.getCreatedDateTime()).isEqualTo(it.getModifiedDateTime());
                }
        );
    }

    @Test
    public void updateData() throws Exception {
        Dado teste = dadoRepository.save(new Dado("teste"));
        teste.setTeste("teste1");
        teste = dadoRepository.save(teste);
        dadoRepository.findById(teste.getId()).ifPresent(
                it -> {
                    assertThat(it.getCreatedDateTime()).isNotNull();
                    assertThat(it.getModifiedDateTime()).isNotNull();
                    assertThat(it.getCreatedDateTime()).isNotEqualTo(it.getModifiedDateTime());
                }
        );
    }

}
