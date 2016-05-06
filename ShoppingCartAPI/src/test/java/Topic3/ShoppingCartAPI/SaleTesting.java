package Topic3.ShoppingCartAPI;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.bootcamp.Topic3.ShoppingCartAPI.ServiceShoppingCart;
import com.bootcamp.Topic3.ShoppingCartAPI.ShoppingCartFactory;
import com.bootcamp.Topic3.ShoppingCartAPI.Sale;
import com.bootcamp.Topic3.ShoppingCartAPI.Item;

public class SaleTesting {

	Sale sale;
	ServiceShoppingCart cart;
	Item item1;
	Item item2;
	
	@Before
	public void setUp(){
		cart=ShoppingCartFactory.getShoppingCart();
		item1=new Item("item 1",10,2);
		item2=new Item("item 2",5,1);
		cart.addItem(item1);
		cart.addItem(item2);
		sale=cart.doCheckOut();
	}
	
	@Test
	public void getTotalSaleTest(){
		assertTrue(25==sale.getTotalSale());
	}
}