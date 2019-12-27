package yc.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class MessageServiceContext {

    private final Map<Integer,MessageService> handelMap = new HashMap<>();

    public MessageService getMessageService(Integer type) {
        return handelMap.get(type);
    }

    public void putMessageService(Integer type,MessageService messageService) {

        handelMap.put(type,messageService);
    }

}
