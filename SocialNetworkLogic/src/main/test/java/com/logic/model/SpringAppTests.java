package java.com.logic.model;

import junit.framework.Assert;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:WEB-INF/spring-config.xml")
public class SpringAppTests {


    /*TODO FIX ME fix test please*/

//    @Autowired
    private HelloService helloService;

//    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello world!", helloService.sayHello());
    }
}
