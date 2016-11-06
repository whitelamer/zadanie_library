package netcracker.school.whitelamer.library.service;

import netcracker.school.whitelamer.library.User;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class LibraryController {

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннотации и настройки пути после деплоя) */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session, HttpServletRequest request) {
        System.out.println("ModelAndView main");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userJSP", new User());
        modelAndView.addObject("path", request.getContextPath());
        System.out.println(request.getContextPath());
        //modelAndView.setViewName("index");
        return modelAndView;
    }

    /*как только на reader.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        System.out.println("ModelAndView checkUser");
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", user);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }
}