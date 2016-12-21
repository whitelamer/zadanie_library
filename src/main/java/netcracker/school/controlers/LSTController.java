package netcracker.school.controlers;

import netcracker.school.models.Category;
import netcracker.school.models.State;
import netcracker.school.models.UserRole;
import netcracker.school.service.CategoryService;
import netcracker.school.service.StateService;
import netcracker.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 01.12.16.
 */
@RestController
public class LSTController {

    @Autowired
    @Qualifier("CategoryService")
    private CategoryService categoryService;
    @Autowired
    @Qualifier("StateService")
    private StateService stateService;

    @RequestMapping(value = "categoryList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<Category> categoryList() {
        return categoryService.getAll();
    }

    @RequestMapping(value = "categoryAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public Category categoryAdd(@RequestBody Category category) {
        categoryService.create(category);
        return category;
    }

    @RequestMapping(value = "categoryEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Category categoryEdit(@RequestBody Category category) {
        categoryService.update(category);
        return category;
    }

    @RequestMapping(value = "stateList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<State> stateList() {
        return stateService.getAll();
    }

    @RequestMapping(value = "stateAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public State stateAdd(@RequestBody State category) {
        stateService.create(category);
        return category;
    }

    @RequestMapping(value = "stateEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public State stateEdit(@RequestBody State category) {
        stateService.update(category);
        return category;
    }
}
