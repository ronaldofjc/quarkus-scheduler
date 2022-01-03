package br.com.scheduler;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@ApplicationScoped
public class CounterBean {

    private static final Logger log = Logger.getLogger(String.valueOf(CounterBean.class));

    private final AtomicInteger counter = new AtomicInteger();

    public int get() {
        return counter.get();
    }

    @Scheduled(every = "10s")
    void increment() {
        counter.incrementAndGet();
    }

    @Scheduled(cron="0 30 09 * * ?")
    void cronjob(ScheduledExecution execution) {
        counter.incrementAndGet();
        log.info("Execution " + execution.getScheduledFireTime());
    }

    @Scheduled(cron="{cron.expr}")
    void cronJobWithExpressionInConfig() {
        counter.incrementAndGet();
        log.info("Cron expression configured in application.properties");
    }
}
