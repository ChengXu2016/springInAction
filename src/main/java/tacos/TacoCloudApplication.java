package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TacoCloudApplication.class, args);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        Arrays.sort(beanDefinitionNames);
//        for (String name : beanDefinitionNames) {
//            System.out.println(name);
//        }
    }

}
