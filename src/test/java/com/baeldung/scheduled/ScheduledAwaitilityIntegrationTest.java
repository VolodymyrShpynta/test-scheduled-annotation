package com.baeldung.scheduled;

import com.baeldung.config.ScheduledConfig;
import org.awaitility.Duration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {ScheduledConfig.class}
)
public class ScheduledAwaitilityIntegrationTest {

    @SpyBean
    private Counter counter;

    @Ignore
    @Test
    public void whenWaitOneSecond_thenScheduledIsCalledAtLeastTenTimes() {
        await()
                .atMost(Duration.ONE_SECOND)
                .untilAsserted(() -> verify(counter, atLeast(10)).scheduled());
    }
}
