package skeleton.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Api(value="", description="Operations on Businesses", position = 1)
@RequestMapping(value="/hello")
@Controller
public class HelloController {

    Logger log = LoggerFactory.getLogger(this.getClass());



    @ApiOperation(value = "Home~~~", httpMethod="GET", position = 2)
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String hello (
            Map<String, Object> model
    )
    {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return "home";
    }

    @ApiOperation(value = "hi !!", httpMethod="GET", position = 3)
    @ResponseBody
    @RequestMapping(value="/hi", method=RequestMethod.GET)
    public String hi (
            @RequestParam(value="name", required=false, defaultValue="World") String name
            , Model model
    )
    {
        model.addAttribute("name", name);
        log.info("in hello2!!");
        
        return "Hi~ there~";
    }
}