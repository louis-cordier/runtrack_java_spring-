//package com.example.jour02;  // ⚠️ même package que Jour02Application
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class ViewController {
//
//    @GetMapping("/message")
//    public String showView(Model model) {
//        model.addAttribute("message", "Bonjour depuis Spring Boot + Thymeleaf !");
//        return "view"; // cherche /templates/view.html
//    }
//}

//package com.example.jour02;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//public class ViewController {
//
//    @GetMapping("/message")
//    public String showView(Model model) {
//        List<String> fruits = Arrays.asList("Pomme", "Banane", "Orange", "Mangue");
//
//        model.addAttribute("fruits", fruits); // envoie la liste à la vue
//        return "view"; // renvoie view.html
//    }
//}

//package com.example.jour02;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class ViewController {
//
//    @GetMapping("/form")
//    public String showForm() {
//        return "view"; // affiche le formulaire
//    }
//
//    @PostMapping("/submit")
//    public String handleForm(@RequestParam("name") String name, Model model) {
//        String message = "Bienvenue, " + name + " !";
//        model.addAttribute("welcomeMessage", message);
//        return "view"; // recharge la même page avec le message
//    }
//}

package com.example.jour02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ViewController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "view";
    }

    @PostMapping("/submit")
    public String handleForm(@Valid @ModelAttribute("userForm") UserForm userForm,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "view"; // retourne le formulaire avec les erreurs
        }

        String message = "Bienvenue, " + userForm.getName() + " ! Tu as " + userForm.getAge() + " ans.";
        model.addAttribute("welcomeMessage", message);
        return "view";
    }
}

