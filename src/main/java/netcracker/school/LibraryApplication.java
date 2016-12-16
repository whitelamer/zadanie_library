package netcracker.school;

import netcracker.school.whitelamer.logmanager.LogManager;
import netcracker.school.whitelamer.logmanager.LogType;
import netcracker.school.whitelamer.logmanager.exceptions.LoggerNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;


@SpringBootApplication
public class LibraryApplication extends SpringBootServletInitializer {
	public static LogManager logger=LogManager.getInstance();

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LibraryApplication.class);
	}



	public static void main(String[] args) throws Exception {


		ConfigurableApplicationContext appContext = SpringApplication.run(LibraryApplication.class, args);

		Resource resource = appContext.getResource("classpath:LogManager.xml");
		logger.loadFromFile(resource.getURI().toString());//настраиваем менеджер
		try {
			logger.writeLog(LogType.WARN, "serverlogger", "Start write to file");//пишем сообщение в логера с именем filelogger
		}catch (LoggerNotFoundException e){
			e.printStackTrace();
		}
	}
}
