package com.Controller;

import com.Model.User;
import com.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //private static final Logger logger = Logger.getLogger(UserController.class);

    /**
     * @param id ID �볺��� ��� ��������� � �볺������ ����
     * */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody void performDelete(@RequestParam("id") int id){
        userService.deleteUserByID(id);
    }

    /**
     * @param id ID �볺���
     * @param model ������ ��� ������������ ������
     * @return ����� jsp-�������
     * */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String performEdit(@RequestParam("id") int id, ModelMap model){
        User user = userService.getUserByID(id);
        model.addAttribute("name", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("city", user.getCity());
        model.addAttribute("id", user.getId());
        return "edit";
    }

    /**
     * @param name ��'� �볺���
     * @param lastName ������� �볺���
     * @param gender ����� �볺���
     * @param city ������ �볺���
     * @param id ID �볺���
     * */
    @RequestMapping(value = "/edit/user", method = RequestMethod.POST)
    public @ResponseBody String performUpdateUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("gender") String gender,
            @RequestParam("city") String city,
            @RequestParam("id") int id
    ){
        userService.updateUser(name,lastName,gender,city, id);
        return "200 OK Success Update";
    }

    /**
     * @return ����� jsp-�������
     * */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(){
        return "insert";
    }

    /**
     * @param name ��'� �볺���
     * @param lastName ������� �볺���
     * @param gender ����� �볺���
     * @param city ������ �볺���
     * */
    @RequestMapping(value = "/insert/user", method = RequestMethod.POST)
    public @ResponseBody String performInsert(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("gender") String gender,
            @RequestParam("city") String city
    ){
        userService.addUser(new User(name,lastName,gender,city));
        return "200 OK Success";
    }
}