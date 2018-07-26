package pl.sda.reservations.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Integer showMin() {
        return null;
    }

    public ResponseEntity<String> showMax() {
        int max;
        if (list.get(0) == null) {
            return ResponseEntity.badRequest().body("Pusta");
        } else {
            max = list.get(0);
            for (int number : list) {

            }
        }

        return null;
    }

    public Integer sortList() {
        ArrayList<Integer> sortList = new ArrayList<>();
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        return null;
    }
}
