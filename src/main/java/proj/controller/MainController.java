package proj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import proj.entity.RandNumMessage;
import proj.service.RandNumService;

@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MainController {
    static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RandNumService randNumService;

    @GetMapping("/")
    public String index() {
        //model.addAttribute("message",
        //        "Hello, Welcme to Spring Boot Based Game");
        return "index";
    }

    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("It's Operate!");
        RandNumMessage random = randNumService.getRandom();
        return ResponseEntity.ok(random);
    }
}
