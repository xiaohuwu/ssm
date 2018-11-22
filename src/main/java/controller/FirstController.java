package controller; /**
 * Created by dell on 2018-11-12.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1、告诉SpringMVC这是一个处理器，可以处理请求
 * @Controller：标识哪个组件是控制器
 */
@Controller
public class FirstController {

    /**
     * @RequestMapping:告诉SpringMVC这个方法处理什么请求； /代表从当前项目下开始；处理当前项目下的hello请求
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String myfirstRequest() {
        System.out.println("请求收到了....正在处理中");
        //视图解析器自动拼串；
//		<property name="prefix" value="/WEB-INF/pages/"></property>
//		<property name="suffix" value=".jsp"></property>
        //   (前缀)/WEB-INF/pages/+返回值(success)+后缀（.jsp）
        return "success";
    }

    /**
     * ?匹配一个字符,0个多个都不行;
     * 模糊和精确多个匹配情况下，精确优先
     *
     * @return
     */
    @RequestMapping("/antTest0?")
    public String antTest02() {
        System.out.println("antTest02...");
        return "success";
    }

    /**
     * *匹配任意多个字符
     *
     * @return
     */
    @RequestMapping(value = "/antTest0*", method = {RequestMethod.POST, RequestMethod.GET})
    public String antTest03() {
        System.out.println("antTest03...");
        return "success";
    }

    /**
     *  *：匹配一层路径
     * @return
     */
    @RequestMapping("/a/*/antTest01")
    public String antTest04(){
        System.out.println("antTest04...");
        return "success";
    }

    /**
     *  *：匹配多层路径
     * @return
     */
    @RequestMapping("/a/**/antTest01")
    public String antTest05(){
        System.out.println("antTest05...");
        return "success";
    }


    //路径上可以有占位符：  占位符 语法就是可以在任意路径的地方写一个{变量名}
    //   /user/admin    /user/leifengyang
    // 路径上的占位符只能占一层路径
    @RequestMapping("/user/{id}")
    public String pathVariableTest(@PathVariable("id")String id){
        System.out.println("路径上的占位符的值:"+id);
        return "success";
    }


}
