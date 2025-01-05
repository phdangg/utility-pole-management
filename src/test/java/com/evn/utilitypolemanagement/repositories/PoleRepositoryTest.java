package com.evn.utilitypolemanagement.repositories;

import com.evn.utilitypolemanagement.entities.Pole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Timestamp;

@DataJpaTest
public class PoleRepositoryTest {
    @Autowired
    PoleRepository poleRepository;

    @Test
    void testSaveMethod_WhenSavePole_ReturnPole() {
        Pole poleEntity = Pole.builder()
                .poleName("poleName")
                .poleShortName("poleShortName")
                .isEnable(true)
                .build();

        Pole pole = poleRepository.save(poleEntity);

        Assertions.assertEquals(poleEntity.getPoleName(), pole.getPoleName());
        Assertions.assertEquals(poleEntity.getPoleShortName(), pole.getPoleShortName());
        Assertions.assertEquals(poleEntity.getIsEnable(), pole.getIsEnable());

    }

    @Test
    public void whenFindByPoleNameOrPoleShortName_thenReturnPole() {

    }
}
