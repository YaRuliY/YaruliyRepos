package com.Controller;

import com.Model.Order;
import com.dao.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private UserService userService;
    private static final Logger logger = Logger.getLogger(OrderController.class);

    /**
     * @param model модель для придставленя данних
     * @return назву сторінки
     * */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(ModelMap model) {
        model.addAttribute("message", "Orders");
        return "order";
    }

    /**
     * @return замовлення клієнтів
     * */
    @RequestMapping(value = "/order/data", method = RequestMethod.GET)
    public @ResponseBody String[][] getData(){
        List<Order> users = userService.getOrders();
        String[][] result = new String[users.size()][2];
        for (int i=0;i<users.size();i++){
            result[i][0] = String.valueOf(users.get(i).getOrder_id());
            result[i][1] = users.get(i).getBuyDate();
        }
        return result;
    }
}