package com.Controller;

import com.Model.User;
import com.DAO.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class GetterController {
    @Autowired
    private UserService userService;
    //private static final Logger logger = Logger.getLogger(GetterController.class);

    /**
     * @return назву сторінки
     * */
    @RequestMapping("/getter")
    public String getter(){
        return "getter";
    }

    /**
     * @return масив всіх клієнтів
     * */
    @RequestMapping(value = "/getter/data", method = RequestMethod.GET)
     public @ResponseBody List<User> getData(){
        return userService.getUser();
    }

    /**
     * @return назву сторінки
     * */
    @RequestMapping("/search")
    public String printSearch() {
        return "search";
    }

    /**
     * @return масив знайдених користувачів
     * @param searchKey ключ покушу
     * */
    @RequestMapping(value = "/search/data", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public @ResponseBody String[][] performSearch(@RequestParam(value = "searchKey", defaultValue = "") String searchKey){
        List<User> users = userService.searchUser(searchKey);
        String[][] result = new String[users.size()][5];
        for (int i=0;i<users.size();i++){
            result[i][0] = String.valueOf(users.get(i).getId());
            result[i][1] = users.get(i).getFirstName();
            result[i][2] = users.get(i).getLastName();
            result[i][3] = users.get(i).getGender();
            result[i][4] = users.get(i).getCity();
        }
        return result;
    }
}