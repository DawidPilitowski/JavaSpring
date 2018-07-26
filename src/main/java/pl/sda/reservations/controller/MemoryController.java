package pl.sda.reservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.reservations.model.MessageObject;
import pl.sda.reservations.service.MemoryService;

import java.util.List;

@RestController
public class MemoryController {
    @Autowired                                                  //automatyczne dołączenie Beana
    private MemoryService memoryService;

    @GetMapping(path = "/dodajLiczbe")
    public ResponseEntity parametrized(@RequestParam(name = "dodajLiczbe") int a) {

        return memoryService.addToList(a);


    }

    @GetMapping(path = "/checkList")
    public ResponseEntity checkList() {

        return ResponseEntity.ok(memoryService.checkList());


    }

    @GetMapping(path = "/removeList")
    public ResponseEntity removeList() {

        return memoryService.clearList();


    }

    @GetMapping(path = "/podajNajmniejsza")
    public ResponseEntity showMin() {

        return memoryService.showMin();


    }

    @GetMapping(path = "/podajNajwieksza")
    public ResponseEntity showMax() {

        return memoryService.showMax();


    }
    @GetMapping(path = "/sortList")
    public ResponseEntity sortList() {

        return memoryService.sortList();
    }

}
