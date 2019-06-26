package com.baeldung.scheduled;

import com.baeldung.config.ScheduledConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {ScheduledConfig.class}
)
public class ScheduledIntegrationTest {

    @Autowired
    Counter counter;

    @Test
    public void givenSleepBy100ms_whenGetInvocationCount_thenIsGreaterThanZero() throws InterruptedException {
        Thread.sleep(100L);

        assertThat(counter.getInvocationCount()).isGreaterThan(0);
    }

}
