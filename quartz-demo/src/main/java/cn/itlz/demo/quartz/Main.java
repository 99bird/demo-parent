package cn.itlz.demo.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.impl.StdSchedulerFactory.getDefaultScheduler;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/10 0010
 */
public class Main {

    public static void main(String[] args) {
        try {
            Scheduler scheduler = getDefaultScheduler();

            JobDetail jobDetail = newJob(HelloJob.class)
                    .withIdentity("job1","gourp1")
                    .usingJobData("name","liuzd")
                    .usingJobData("handsome",100)
                    .build();

            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);

            scheduler.start();
//            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
