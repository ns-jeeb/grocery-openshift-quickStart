package jeeb.controllers;

import jeeb.model.Order;
import jeeb.model.User;
import jeeb.utilities.ParsingJsons;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Jeeb on 10/24/2015.
 */
@Controller
@RequestMapping
public class GreetingController {

    List<User> mUsers;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        ParsingJsons userParsed = new ParsingJsons ();
        mUsers = userParsed.users ();
        ModelAndView modelView = new ModelAndView ("index");
        modelView.addObject ("users", mUsers);
        return modelView;
    }
    @RequestMapping(value = "/users")
    public String users(@RequestParam(required=false) Integer id, User user, Map<String, Object> map){
        User user1 = new User ();
        map.put ("userList", user1);
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String userDate(@ModelAttribute("user")User user, BindingResult result, ModelMap modelMap){
        modelMap.addAttribute ("user", user);
        return "users";
    }


//    @ModelAttribute("user")
//    public User construct (){
//        return new User ();
//    }
//    @RequestMapping("/register")
//    public String register(ModelMap modelMap, User user, BindingResult result){
//
//        return "register";
//    }
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String doRegister(@ModelAttribute("user")User user, BindingResult result, ModelMap modelMap){
//        modelMap.addAttribute ("user", user);
//        return "register";
//    }


    @ModelAttribute("Order")
    public Order constructOrder (){
        return new Order ();
    }
    @RequestMapping("/order")
    public String order(ModelMap modelMap, Order order, BindingResult result){

        return "kidsEducation";
    }
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String doOrder(@ModelAttribute("Order")Order order, BindingResult result, ModelMap modelMap){
        modelMap.addAttribute ("order", order);
        return "kidsEducation";
    }

}
