package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * @author madrabit
 * Every day start Job(Parser) by cron time.
 */
public class Quartz {
    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger(Quartz.class.getName());

    public static void main(String[] args) {

        SchedulerFactory factory = new StdSchedulerFactory();
        try (InputStream in = Quartz.class.getClassLoader().getResourceAsStream("parser.properties")) {
            Properties config = new Properties();
            config.load(Objects.requireNonNull(in));
            String cron = config.getProperty("cron.time");

            Scheduler scheduler = factory.getScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(UpdateJob.class).withIdentity("job1", "group1").build();

            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .forJob(job)
                    .build();

            scheduler.scheduleJob(job, trigger);

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

    }
}
