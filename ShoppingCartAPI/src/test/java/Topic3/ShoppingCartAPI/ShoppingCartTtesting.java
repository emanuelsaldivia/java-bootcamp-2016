package Topic3.ShoppingCartAPI;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.bootcamp.Topic3.ShoppingCartAPI.ServiceShoppingCart;
import com.bootcamp.Topic3.ShoppingCartAPI.ShoppingCartImp;
import com.bootcamp.Topic3.ShoppingCartAPI.ShoppingCartFactory;
import com.bootcamp.Topic3.ShoppingCartAPI.Sale;
import com.bootcamp.Topic3.ShoppingCartAPI.Item;

public class ShoppingCartTtesting {

	ServiceShoppingCart cart;
	Item item1;
	Item item2;
	Item item3;
	
	@Before
	public void setUp () throws Exception{
		cart= ShoppingCartFactory.getShoppingCart();
		item1=new Item("item 1",5,100);
		item2=new Item("item 2",2,10);
		item3=new Item("item 3",10,1);
		
		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);
		
		cart.deleteItem(item2);
	}
	
	@Test
	public void addItemTest(){
		assertTrue(cart.addItem(item1));
		assertTrue(cart.addItem(item2));
	}
	
	@Test
	public void deleteItemTest(){
		assertTrue(cart.deleteItem(item2));
		assertTrue(cart.deleteItem(item3));
		cart.deleteItem(item3);
		assertTrue(cart.deleteItem(item3));
	}
	
	@Test
	public void doCheckOutTest(){
		Sale sale;
		sale=cart.doCheckOut();
		assertTrue(510==sale.getTotalSale());
	}
	
	@Test
	public void clearCartTest(){
		cart.clearCart();
		assertTrue(null==cart);
	}
	
	@Test
	public void getItemTest(){
		assertTrue(item1==cart.getItem(1));
		}
}
