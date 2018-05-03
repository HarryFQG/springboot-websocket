package m.itiandou.com.websocket2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fengqigui
 * @description
 * @date 2018/05/02 15:53
 */
@Controller
public class ChatController {


    @RequestMapping("/chat")
    public String chat(Model model){

        model.addAttribute("title","聊天室");
        return "chat";
    }

    @RequestMapping("/")
    public String indext(Model model){

        model.addAttribute("title","聊天室");
        return "index";
    }
}
