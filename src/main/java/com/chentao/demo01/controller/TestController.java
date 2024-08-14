package com.chentao.demo01.controller;

import com.chentao.demo01.pojo.bo.MicroServiceUrlBo;
import com.chentao.demo01.pojo.bo.UserBo;
import com.chentao.demo01.util.JsonResultUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
/*
*  @RestController 注解包含了原来的 @Controller 和 @ResponseBody 注解，
*  @ResponseBody 注解是将返回的数据结构转换为 Json 格式。
* */
@RequestMapping(value = "/test", produces = "application/json; charset=UTF-8")
/*
* @RequestMapping 是一个用来处理请求地址映射的注解，它可以用于类上，也可以用于方法上。
* 在类的级别上的注解会将一个特定请求或者请求模式映射到一个控制器之上，表示类中的所有响应请求的方法都是以该地址作为父路径；
* 在方法的级别表示进一步指定到处理方法的映射关系。
* 该注解有6个属性，一般在项目中比较常用的有三个属性：value、method 和 produces。
* value 属性：指定请求的实际地址，value 可以省略不写
* method 属性：指定请求的类型，主要有 GET、PUT、POST、DELETE，默认为 GET
* produces属性：指定返回内容类型，如 produces = “application/json; charset=UTF-8”
* */
@Tag(name = "TestController", description = "测试接口")
/*
* 类注释：@Tag(name = "ArticleController", description = "文章接口")
* 方法注释：@Operation(summary = "根据文章ID获取文章对象")
* 参数注释：@Parameter(description = "文章ID", required = true)
* 返回值: @ApiResponses(value = {@ApiResponse(description = "文章对象")})
* */
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class.getName());

    @Operation(summary = "获取testLog")
    @RequestMapping(value = "/testLog", method = RequestMethod.GET)
    public JsonResultUtils<String> testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息FFDF
        String str1 = "www.felixchen.top";
        String str2 = "kirby";
        logger.info("======测试：{} {}", str1, str2);

        return new JsonResultUtils<>("Success");
    }

    @Value("${url.orderUrl}")
    private String orderUrl;

    @GetMapping("/testReadYml")
    public JsonResultUtils<String> testReadYml() {
        logger.info("====获取的订单服务地址为: {}",orderUrl);
        return new JsonResultUtils<>("====获取的订单服务地址为: "+ orderUrl);
    }


    @Resource
    private MicroServiceUrlBo microServiceUrl;

    @GetMapping("/testConfig")
    public JsonResultUtils<String> testConfig() {
        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());
        return new JsonResultUtils<>("Success");
    }

    @GetMapping("/user/{idd}")
    public String testPathVariable(@PathVariable(value = "idd")Integer id) {
        System.out.println("获取到的id为：" + id);
        return "获取到的id为：" + id;
    }
    /*
    * @PathVariable 注解主要是用来获取 url 参数，
    * Spring Boot 支持 restfull 风格的 url，
    * 比如一个 GET 请求携带一个参数 id 过来，我们将 id 作为参数接收，
    * 可以使用 @PathVariable 注解
    * 这里需要注意一个问题，如果想要 url 中占位符中的 id 值直接赋值到参数 id 中，
    * 需要保证 url 中的参数和方法接收参数一致，否则就无法接收。
    * 如果不一致的话，其实也可以解决，需要用 @PathVariable 中的 value 属性来指定对应关系。
    * */

    @GetMapping("/user/{idd}/{name}")
    /*
    * 对于访问的 url，占位符的位置可以在任何位置，不一定非要在最后，比如这样也行：/xxx/{id}/user。
    * 另外，url 也支持多个占位符，方法参数使用同样数量的参数来接收，原理和一个参数是一样的
    * */
    public String testPathVariable(@PathVariable(value = "idd") Integer id, @PathVariable String name) {
        System.out.println("获取到的id为：" + id);
        System.out.println("获取到的name为：" + name);
        return "获取到的id为：" + id+ "\n"+ " 获取到的name为：" + name;
    }

    /*
    * @PathValiable 是从 url 模板中获取参数值，
    * 即这种风格的 url：http://localhost:8080/user/{id} ；
    * 而 @RequestParam 是从 request 里面获取参数值，
    * 即这种风格的 url：http://localhost:8080/user?id=1 。
    * */
    @GetMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "idd", required = false)  @Parameter(name = "idd",description = "用户唯一标识") Integer id) {
        System.out.println("获取到的id为：" + id);
        return "获取到的id为：" + id;
    }

    /*
    * 从 url 中可以看出，@RequestParam 注解用于 GET 请求上时，接收拼接在 url 中的参数。
    * 除此之外，该注解还可以用于 POST 请求，接收前端表单提交的参数，
    * 假如前端通过表单提交 username 和 password 两个参数，那我们可以使用 @RequestParam 来接收
    * */
    @RequestMapping(value = "/form1",method = RequestMethod.POST)
    public String testForm(@RequestParam(required = false) String username, @RequestParam(required = false) String password) {
        System.out.println("获取到的username为：" + username);
        System.out.println("获取到的password为：" + password);
        return "获取到的id为：" + username+ "\n"+ " 获取到的name为：" + password;
    }

    /*
    * @RequestBody 注解用于接收前端传来的实体，接收参数也是对应的实体，
    * 比如前端通过 json 提交传来两个参数 username 和 password，此时我们需要在后端封装一个实体来接收。
    * 在传递的参数比较多的情况下，使用 @RequestBody 接收会非常方便。
    * */
    @PostMapping("/form2User")
    public String testForm(@RequestBody UserBo user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "获取到的id为：" +  user.getUsername()+ "\n"+ " 获取到的name为：" +  user.getPassword();
    }

    /*
    * 本节课主要讲解了 Spring Boot 中对 MVC 的支持，
    * 分析了 @RestController、 @RequestMapping、@PathVariable、 @RequestParam 和 @RequestBody 四个注解的使用方式，
    * 由于 @RestController 中集成了 @ResponseBody 所以对返回 json 的注解不再赘述。
    * 以上四个注解是使用频率很高的注解，在所有的实际项目中基本都会遇到，要熟练掌握。
    * */

}
