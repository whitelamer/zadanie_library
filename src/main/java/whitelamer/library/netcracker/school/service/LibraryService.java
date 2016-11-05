package whitelamer.library.netcracker.school.service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LibraryService {

    public String getDesc() {

        return "Spring MVC Library";

    }

    public String getTitle(String name) {
        if(!StringUtils.isEmpty(name)){
            return "Hello " + name;
        }
        return "";

    }

}