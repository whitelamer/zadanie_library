package netcracker.school;

import javax.xml.stream.XMLStreamException;
import netcracker.school.whitelamer.logmanager.LogManager;
import netcracker.school.whitelamer.logmanager.LogType;
import netcracker.school.whitelamer.logmanager.exceptions.LoggerNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication
public class LibraryApplication extends SpringBootServletInitializer {
	public static LogManager logger=LogManager.getInstance();

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LibraryApplication.class);
	}



	public static void main(String[] args) throws Exception {

		logger.loadFromFile("LogManager.xml");//настраиваем менеджер
		SpringApplication.run(LibraryApplication.class, args);
		try {
			logger.writeLog(LogType.WARN, "filelogger", "Start write to file");//пишем сообщение в логера с именем filelogger
		}catch (LoggerNotFoundException e){
			e.printStackTrace();
		}
	}
}
