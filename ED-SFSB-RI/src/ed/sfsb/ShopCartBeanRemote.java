/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.sfsb;

import dto.CartItem;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author calum
 */
@Remote
public interface ShopCartBeanRemote {

	public boolean addCartItem(CartItem cartItem);
	
	public boolean deleteCartItem(String itemId);
	
	public boolean updateCartItem(CartItem cartItem);
	
	public ArrayList<CartItem> getCart();
	
}
