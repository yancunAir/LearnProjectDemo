package yc.designpattern.strategy;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

public class MessageHandleListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Map<String, Object>  msgTypeMap =
          contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(MsgTypeHandler.class);

        MessageServiceContext messageServiceContext =
                contextRefreshedEvent.getApplicationContext().getBean(MessageServiceContext.class);

        msgTypeMap.forEach((name,bean)->{
            MsgTypeHandler typeHandler = bean.getClass().getAnnotation(MsgTypeHandler.class);
            messageServiceContext.putMessageService(typeHandler.value().code,(MessageService) bean);
        });



    }
}
