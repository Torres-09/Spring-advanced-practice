package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.template.CallBack;
import hello.advanced.trace.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallBackTest {
    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callBackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 실행");
            }
        });
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    @Test
    void callBackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(()->log.info("비즈니스 로직 1 실행"));
        template.execute(()->log.info("비즈니스 로직 2 실행"));
    }
}
