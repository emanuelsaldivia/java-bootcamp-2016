package topic1.maven;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
    
    
    private static App app;
    
private static App apptest;
    
    @BeforeClass
    public void setUp() {
    	app= new App(1, 2);
	}
    
    @Test
    public void testBigger() {
    	assertEquals(2, app.bigger());
    	assertNotEquals(1, app.bigger());
	}
    
    @Test
    public void testLower(){
    	assertEquals(1, app.lower());
    	assertNotEquals(2, app.lower());
    }
}
