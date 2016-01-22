package jeeb.controllers;

import jeeb.jeeb.DataSource;
import jeeb.model.Item;
import jeeb.model.TempTable;
import jeeb.model.User;
import jeeb.utilities.ParsingJsons;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeeb on 11/9/2015.
 */
@Controller
@RequestMapping
public class GroceryController {
    List<List<String>> mMeats;

    @ModelAttribute("grocery")
    public Item construct (){
        return new Item ();
    }

    @RequestMapping("/grocery")
    public String viewGroceryForm(ModelMap modelMap, Item meat, BindingResult result) throws IOException {
        String resource = getClass ().getSimpleName ();
        System.out.println (resource);


        ParsingJsons parssingJson = new ParsingJsons ();
//        this data comes from mongodbs
        mMeats = parssingJson.parssingGrocery ();
        List<String>beefs = new ArrayList<String> ();
        List<String>goats = new ArrayList<String> ();
        List<String>lams = new ArrayList<String> ();
        List<String>porks = new ArrayList<String> ();
        List<String>chicks = new ArrayList<String> ();
        List<String>fruits = new ArrayList<String> ();
        List<String>veges = new ArrayList<String> ();
        for (List<String>items : mMeats){
            if (items.contains ("Vegetable")){
                veges = items;
            }else if (items.contains ("Fruit")){
                fruits = items;
            }else if (items.contains ("Beef")){
                beefs = items;
            }else if (items.contains ("Pork")){
                porks = items;
            }else if (items.contains ("Goat")){
                goats = items;
            }else if (items.contains ("Chicken")){
                chicks = items;
            }else if (items.contains ("Lamb")){
                lams = items;

            }
        }
        modelMap.addAttribute ("beef", beefs);
        modelMap.addAttribute ("lamb", lams);
        modelMap.addAttribute ("goat", goats);
        modelMap.addAttribute ("pork", porks);
        modelMap.addAttribute ("chicken", chicks);
        modelMap.addAttribute ("fruit", fruits);
        modelMap.addAttribute ("vegetable", veges);

        return "grocery";


    }
    @RequestMapping(value = "/grocery", params = "createTable",method = RequestMethod.POST)
    public String sendGroceryFrom(@ModelAttribute Item meat, BindingResult result, ModelMap modelMap) throws IOException {

        DataSource dataSource = new DataSource ();

        modelMap.addAttribute ("meatsParts",meat.getPartName ());
        modelMap.addAttribute ("isChecked",meat.isChecked ());
        String message = dataSource.creatingTempTable (meat.getPartName ());

        modelMap.addAttribute ("message",message);

        return "done_grocery";
    }
    // this method create string and split with comma and and make array with a word has capital letter
//    public List<List<String>> toManageData(List<String>dataList){
//        String[] r = {};
//        StringBuilder sb = new StringBuilder ();
//        for (String s : dataList){
//            sb.append (s);
//            sb.append (",");
//            r = sb.toString ().split ("(?=\\p{Upper})");
//        }
//        List<List<String>> meatItems = createListOfMeatFromArray(r);
//        return meatItems;
//    }
//    //this convert array to multiple list of meat
//    public List<List<String>> createListOfMeatFromArray(String[]strings){
//        List<List<String>> meatList = new ArrayList<List<String>>();
//        for (String index : strings) {
//
//            if (index != null && index.contains ("beef")) {
//                meatList.add (Arrays.asList (index.split (",")));
//            }else if (index != null && index.contains ("lamb")){
//                meatList.add (Arrays.asList (index.split (",")));
//
//            }else if (index != null && index.contains ("goat")){
//                meatList.add (Arrays.asList (index.split (",")));
//
//            }else if (index != null && index.contains ("chicken")){
//                meatList.add (Arrays.asList (index.split (",")));
//
//            }else if (index != null && index.contains ("pork")){
//                meatList.add (Arrays.asList (index.split (",")));
//
//            }
//        }
//        if (meatList!= null){
//            return meatList;
//        }
//        return null;
//    }

    @RequestMapping(value="/grocery",params="CompleteGrocery", method = RequestMethod.POST)
    public String createTempTable(@ModelAttribute TempTable tempData, BindingResult result, ModelMap modelMap){

        modelMap.addAttribute ("good","good job");
        return "success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String loginPage(Model model, Principal principal, User user) {
        model.addAttribute("title", "Login");
        model.addAttribute("message", "Enter your username/password:");

        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String loginPageSubmit(Model model, Principal principal, User user) {
        model.addAttribute("title", "User Info");

        // Sau khi user login thanh cong se co principal
        String userName = user.getName ();

        model.addAttribute("message","User Info - This is protected page!. Hello " + userName);
        if (user.getName ().equalsIgnoreCase ("najeeb")){
            model.addAttribute ("message","Welcome");
        }else{
            model.addAttribute ("message","password is encorrect");
        }

        return "logingSuccess";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        model.addAttribute("title", "Access Denied!");

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "success";
    }

}
