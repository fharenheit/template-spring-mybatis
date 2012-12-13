package kr.co.cloudine.template.standalone;

import kr.co.cloudine.template.standalone.domain.User;
import kr.co.cloudine.template.standalone.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test Application
 *
 * @author Edward KIM
 * @since 1.0
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserRepository userRepository = context.getBean(UserRepository.class);

        User user = new User();
        user.setUsername("fharenheit");
        user.setPassword("fharenheit");
        user.setName("hong gil dong");
        userRepository.insert(user);

        System.out.println("Primary Key : " + user.getId());

        System.out.println(userRepository.delete(2));

        System.out.println(userRepository.select(1));

        System.out.println(userRepository.exists(1));

        User selected = userRepository.select(1);
        selected.setName("Edward");
        userRepository.update(selected);
    }

}
