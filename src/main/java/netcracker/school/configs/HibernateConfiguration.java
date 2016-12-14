package netcracker.school.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "netcracker.school.configs" })
@PropertySource(value = { "classpath:application.properties" })
@ImportResource({ "classpath:/WEB-INF/spring/data.xml" })
public class HibernateConfiguration {
}
