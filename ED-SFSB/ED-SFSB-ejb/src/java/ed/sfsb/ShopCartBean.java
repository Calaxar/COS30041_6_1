/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.sfsb;

import dto.CartItem;
import java.util.ArrayList;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author calum
 */
@Stateful
public class ShopCartBean implements ShopCartBeanRemote {

	private ArrayList<CartItem> cart;

	public ShopCartBean() {
		cart = new ArrayList<>();
	}

	private boolean add(CartItem cartItem) {
		boolean result = false;
		try {
			result = cart.add(cartItem);
		} catch (Exception ex) {
		}
		return result;
	}

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
			for (CartItem item : cart) {
				if (item.getItemId().equals(cartItem.getItemId())) {
					item.setQuantity(item.getQuantity() + cartItem.getQuantity());
					return true;
				}
			}
			add(cartItem);
			return true;
		} catch (Exception e) {
			System.err.println(e.toString());
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(String itemId) {
		try {
			for (CartItem item : cart) {
				if (item.getItemId().equals(itemId)) {
					cart.remove(item);
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			if (cart.contains(cartItem)) {
				cart.set(cart.indexOf(cartItem), cartItem);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	@Remove
	public void remove() {
		cart = null;
	}

	@Override
	public ArrayList<CartItem> getCart() {
		return cart;
	}
}
