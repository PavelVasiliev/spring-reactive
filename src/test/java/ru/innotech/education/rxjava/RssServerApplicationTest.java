package ru.innotech.education.rxjava;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import ru.innotech.education.rxjava.config.DatabaseTestConfiguration;

@ActiveProfiles("test")
@SpringBootTest
@Import(DatabaseTestConfiguration.class)
class RssServerApplicationTest {

    @Test
    void loadContext() {
    }
}