package inside.test.task.controller;

import inside.test.task.entity.MessageEntity;
import inside.test.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

    @Autowired
    UserService service;

    @GetMapping("/user/history10")
    public String getHistory() {
        return service.getHistory();
    }

    @PostMapping("/user/send")
    public String saveBook(@RequestBody MessageEntity message) {
        service.SaveMessage(message);
        return "OK";
    }
}
