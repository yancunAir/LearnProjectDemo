package yc.designpattern.strategy;

import org.springframework.stereotype.Service;

@Service
@MsgTypeHandler(MessageType.TEXT)
public class TextMessageService implements MessageService {

    @Override
    public void handleMessage(MessageInfo messageInfo) {
        System.out.println("text start to handle"+messageInfo.getContent());
    }
}
