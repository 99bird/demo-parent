package cn.itlz.demo.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/10 0010
 */
public class HelloJob implements Job {

    public HelloJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        int val = jobDataMap.getInt("handsome");

        System.out.println("Hello this is a job");
        System.out.println(val);
    }
}
