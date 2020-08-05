package cn.ming.springboot.task.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ren.xm
 * @description
 * @date 2020/8/5
 */
@Component
@JobHandler("demoJob") //添加 @JobHandler 注解，设置 JobHandler 的名字。后续，我们在调度中心的控制台中，新增任务时，需要使用到这个名字
public class DemoJob extends IJobHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final AtomicInteger counts = new AtomicInteger();

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        // 打印日志
        logger.info("[execute][定时第 ({}) 次执行]", counts.incrementAndGet());
        // 返回执行成功
        return ReturnT.SUCCESS;
    }

}
