package ch.bbw.ft.Spiel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class SpielController {

    @GetMapping("/tuerspiel")
    public String showSpiel(Model model) {
        model.addAttribute("tuer", new Tuer());
        return "index";
    }

    @PostMapping("/tuerspiel")
    public String showResult(@ModelAttribute Tuer tuer) {
        Random random = new Random();
        int winnerDoor = random.nextInt(3);
        if (tuer.getInput() - 1 == winnerDoor) {
            tuer.setResponse("Sie haben gewonnen!");
        } else {
            tuer.setResponse("Sie haben leider verloren");
        }
        return "index";
    }
}
