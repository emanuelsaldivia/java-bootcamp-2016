package Topic3.ShoppingCartAPI;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.bootcamp.Topic3.ShoppingCartAPI.Item;

public class ItemTesting {

	Item item;
	
	@Before
	public void setUp() throws Exception{
		item=new Item("item",5,100);
	}
	
	@Test
	public void getFinalPriceTest(){
		assertTrue(500==item.getFinalItemPrice());
	}
	
}
