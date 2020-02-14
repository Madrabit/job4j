package ru.job4j.parser;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author madrabit
 * Quartz job which update parser database with today updates.
 */
public class UpdateJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Job started");

        DataBase base = new DataBase();
        base.init();
        Parser parser = new Parser();

        parser.update();
        base.update(parser.getVacancySet());
    }
}
