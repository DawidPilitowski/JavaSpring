package pl.sda.reservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.reservations.model.MessageObject;

import pl.sda.reservations.model.SquareObjectInMinus;
import pl.sda.reservations.model.SquareObjectInPlus;
import pl.sda.reservations.model.SquareObjectZero;
import pl.sda.reservations.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {
    @Autowired                                                  //automatyczne dołączenie Beana
    private MessageService messageService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public ResponseEntity index() {
        return ResponseEntity.ok(new MessageObject("Hello!")); // wyświetlania obiektów JSON
    }

    @RequestMapping(path = "/count", method = RequestMethod.GET)
    public ResponseEntity count() {
        return ResponseEntity.ok(messageService.getCounter());
    }

    @GetMapping(path = "/square")
    public ResponseEntity kwadratowe(@RequestParam(name = "a") int a,
                                     @RequestParam(name = "b") int b,
                                     @RequestParam(name = "c") int c) {

        double delta = b * b - 4 * a * c;
        if (delta > 0) {

            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);

            return ResponseEntity.ok(new SquareObjectInPlus(x1, x2, delta));
        } else if (delta == 0) {
            double x0 = (-b) / (2 * a);

            return ResponseEntity.ok(new SquareObjectZero(x0, delta));
        } else {
            return ResponseEntity.ok(new SquareObjectInMinus(delta));

        }

    }

    @GetMapping(path = "/parametrized")
    public ResponseEntity parametrized(@RequestParam(name = "who") String who) {
        return ResponseEntity.ok(new MessageObject("Hello " + who + "!"));                              //zawsze trzeba zwracać ResponseEntity!!!
    }

    @GetMapping(path = "/new")
    public ResponseEntity parametrized(@RequestParam(name = "start") int start,
                                       @RequestParam(name = "end") int end, @RequestParam(name = "divider") int divider) {

        if (start > end) {
            return ResponseEntity.ok(new MessageObject("nie działa"));
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = start; i < end; i++) {
                if (i % divider == 0) {
                    list.add(i);
                }

            }
            return ResponseEntity.ok(new MessageObject("Wynik" + list));
        }
    }

    @GetMapping(path = "/schoop")
    public ResponseEntity parametrized(@RequestParam(name = "text") int r) {

        List<Integer> list = new ArrayList<>();
        String a = "tekst";
        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                int cyfraZeZnaku = a.charAt(i) - 48;
                list.add(cyfraZeZnaku);
            }


        }
        return ResponseEntity.ok(list);
    }
}
