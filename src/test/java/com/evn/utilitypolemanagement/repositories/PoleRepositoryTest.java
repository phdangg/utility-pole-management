package com.evn.utilitypolemanagement.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class PoleRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void whenFindByPoleNameOrPoleShortName_thenReturnPole() {

    }
}
