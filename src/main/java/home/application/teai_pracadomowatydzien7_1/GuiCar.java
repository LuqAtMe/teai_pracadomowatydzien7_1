package home.application.teai_pracadomowatydzien7_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuiCar {

    private DaoCars daoCars;

    @Autowired
    public GuiCar(DaoCars daoCars) {
        this.daoCars = daoCars;
    }

    @GetMapping("/cars")
    public String showCars(Model model) {
        model.addAttribute("carList", daoCars.getCarList());
        model.addAttribute("newCar", new Car());
        return "cars";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Car newCar) {
        daoCars.saveCar(newCar);
        return "redirect:/cars";
    }

    @PostMapping("/selectedCars")
    public String selectedCars(@RequestParam int yearMin, @RequestParam int yearMax) {
        daoCars.getCarsInSpecificRange(yearMin, yearMax);
        return "redirect:/cars";
    }

    @PostMapping("/reloadDB")
    public String reloadDatabase() {
        daoCars.updateCarsFromDB();
        return "redirect:/cars";
    }
}

