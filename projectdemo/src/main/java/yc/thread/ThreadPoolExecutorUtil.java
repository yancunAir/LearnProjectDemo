package yc.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.*;

public class ThreadPoolExecutorUtil {

    private int corePoolSize;
    private int maximumPoolSize;
    private long keepAliveTime;
    private TimeUnit unit;
    private BlockingQueue<Runnable> workQueue;

    private static volatile ThreadPoolExecutorUtil INSTANCE;

    private ThreadPoolExecutorUtil(){}

    private static Map<String,ExecutorService> executorServiceMap = new ConcurrentHashMap<>();


    public static ThreadPoolExecutorUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (INSTANCE == null) {
                    return new ThreadPoolExecutorUtil();
                }
            }
        }
        return INSTANCE;
    }

    /**
     *
     * @param corePoolSize 核心线程数
     * @param maximumPoolSize 最大线程数
     * @param keepAliveTime 空闲线程等待时间
     * @param unit 空闲线程等待单元
     * @param workQueueSize 工作队列大小
     * @param poolName 线程池名字
     * @return 线程池
     */
    public static ExecutorService getThreadPoolExecutor(int corePoolSize,int maximumPoolSize,
                                                           long keepAliveTime,TimeUnit unit,
                                                           int workQueueSize,
                                                           String poolName) {
        if (corePoolSize <= 0 || corePoolSize > maximumPoolSize ||
                StringUtils.isEmpty(poolName) ||workQueueSize <= 0) {
            throw new IllegalArgumentException("getThreadPoolExecutor argument illegal.");
        }

        if (executorServiceMap.containsKey(poolName)) {

            return executorServiceMap.get(poolName);
        }

        return new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,
                new LinkedBlockingQueue<>(workQueueSize),
                new BasicThreadFactory.Builder().namingPattern(poolName + "-%d").daemon(false).build(),
                new ThreadPoolExecutor.AbortPolicy());

    }

}
