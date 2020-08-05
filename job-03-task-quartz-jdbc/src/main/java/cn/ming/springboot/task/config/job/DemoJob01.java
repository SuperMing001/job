package cn.ming.springboot.task.config.job;

import cn.ming.springboot.task.service.DemoService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author ren.xm
 * @description
 * @date 2020/8/5
 */
@DisallowConcurrentExecution
public class DemoJob01 extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DemoService demoService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        logger.info("[executeInternal][我开始的执行了, demoService 为 ({})]", demoService);
    }

}
