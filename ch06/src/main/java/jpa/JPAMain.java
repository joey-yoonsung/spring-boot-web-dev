package jpa;

import jpa.model.UserEntity;
import jpa.model.UserRole;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import jpa.repository.UserRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
//@SpringBootApplication
public class JPAMain {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.save(new UserEntity("윤사장", 60, UserRole.ADMIN));
        UserEntity user = userRepository.findByUserName("윤사장");
        System.out.println(ToStringBuilder.reflectionToString(user, ToStringStyle.DEFAULT_STYLE));
    }
}
