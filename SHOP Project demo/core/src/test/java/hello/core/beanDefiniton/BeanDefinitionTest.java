package hello.core.beanDefiniton;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(AppConfig.class);

//    GenericXmlApplicationContext ac =
//            new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("bean meta information check")
    void findApplicationBean() {
        String[] names = ac.getBeanDefinitionNames();
        for (String key : names) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(key);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitonName=" + key + "beanDefinition = " + beanDefinition) ;
            }

        }
    }



}
