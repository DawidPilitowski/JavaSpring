package pl.sda.reservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.reservations.service.MemoryService;


@RestController
public class MemoryController {
    @Autowired                                                  //automatyczne dołączenie Beana
    private MemoryService memoryService;

    @GetMapping(path = "/addNumber")
    public ResponseEntity parametrized(@RequestParam(name = "addNumber") int a) {

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

    @GetMapping(path = "/showMin")
    public ResponseEntity showMin() {

        return memoryService.showMin();


    }

    @GetMapping(path = "/showMax")
    public ResponseEntity showMax() {

        return memoryService.showMax();


    }
    @GetMapping(path = "/sortList")
    public ResponseEntity sortList() {

        return memoryService.sortList();
    }

}
