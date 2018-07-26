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
        return ResponseEntity.ok(number + " number added");
    }

    public ResponseEntity clearList() {
        list.clear();
        return ResponseEntity.ok("clear");
    }

    public ResponseEntity<String> showMin() {
        int min = 0;
        if (list.get(0) == null) {
            return ResponseEntity.badRequest().body("Empty");
        } else {
            min = Collections.min(list);
        }
        return ResponseEntity.ok("min: " + min);
    }

    public ResponseEntity<String> showMax() {
        int max;
        if (list.get(0) == null) {
            return ResponseEntity.badRequest().body("Empty");
        } else {
            max = Collections.max(list);
        }

        return ResponseEntity.ok("min: " + max);
    }

    public ResponseEntity sortList() {
        Collections.sort(list);
        for(Integer sorted: list){
            System.out.println(sorted);
        }
        return ResponseEntity.ok(list);
    }
}
