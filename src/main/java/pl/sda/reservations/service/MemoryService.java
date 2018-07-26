package pl.sda.reservations.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MemoryService {
    private List<Integer> list = new ArrayList<>();


    public List<Integer> checkList() {
        return list;
    }

    public ResponseEntity addToList(int number) {
        list.add(number);
        return ResponseEntity.ok(number + " added");
    }

    public ResponseEntity clearList() {
        list.clear();
        return ResponseEntity.ok("clear");
    }

    public ResponseEntity<String> showMin() {
        int min = 0;
        if (list.get(0) == null) {
            return ResponseEntity.badRequest().body("Pusta");
        } else {
            min = Collections.min(list);
        }
        return ResponseEntity.ok("min: " + min);
    }

    public ResponseEntity<String> showMax() {
        int max;
        if (list.get(0) == null) {
            return ResponseEntity.badRequest().body("Pusta");
        } else {
            max = Collections.max(list);
        }

        return ResponseEntity.ok("min: " + max);
    }

    public ResponseEntity sortList() {
        ArrayList<Integer> sortList = new ArrayList<>();

        Collections.sort(list);
//        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        for(Integer sorted: list){
            System.out.println(sorted);
        }
        return ResponseEntity.ok(list);
    }
}
