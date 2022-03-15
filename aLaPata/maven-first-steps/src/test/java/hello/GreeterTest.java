package hello;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GreeterTest {

    @Test
    public void testSayHello() {
        Greeter greeter = new Greeter();
        String result = greeter.sayHello();
        assertThat(result, containsString("Hello"));
        assertThat(result,containsString("How"));
        assertThat(result, not(containsString("shit")));
    }
}