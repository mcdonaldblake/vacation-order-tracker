@Controller
public class FrontendController {
    @RequestMapping(value = {
        "/", 
        "/{path:[^\\.]*}", 
        "/**/{path:[^\\.]*}"
    })
    public String forward() {
        return "forward:/index.html";
    }
}
