package application.contro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @Test
    public void testSayHello()
    {
        assertEquals("Hello,World!",new HelloWorldController().sayHello());
    }
}
