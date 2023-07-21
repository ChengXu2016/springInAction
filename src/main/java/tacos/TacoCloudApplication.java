package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tacos.config.TacoProps;

@SpringBootApplication
public class TacoCloudApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TacoCloudApplication.class, args);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        Arrays.sort(beanDefinitionNames);
//        for (String name : beanDefinitionNames) {
//            System.out.println(name);
//        }
        TacoProps tacoProps = applicationContext.getBean(TacoProps.class);
        System.out.println("page size = " + tacoProps.getPageSize());
        System.out.println("str liset = " + tacoProps.getStrList());
    }

}
