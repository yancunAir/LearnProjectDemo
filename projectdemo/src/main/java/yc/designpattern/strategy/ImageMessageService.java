package yc.designpattern.strategy;

import org.springframework.stereotype.Service;

@Service
@MsgTypeHandler(MessageType.IMAGE)
public class ImageMessageService implements MessageService {


    @Override
    public void handleMessage(MessageInfo messageInfo) {
        System.out.println("Image start to handle"+messageInfo.getContent());
    }
}
