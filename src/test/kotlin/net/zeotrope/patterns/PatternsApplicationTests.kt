package net.zeotrope.patterns

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class PatternsApplicationTests(val applicationContext: ApplicationContext) {
    @Test
    fun contextLoads() {
        assertNotNull(applicationContext)
    }
}
