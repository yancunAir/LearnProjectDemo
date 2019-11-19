package yc.aop;

public class ChinesePeople implements People {
    @Override
    public void say() {
        System.out.println("我说中文。");
    }
}
