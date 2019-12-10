package com.briup.app.estore.bean;

import java.util.ArrayList;
import java.util.List;

import com.briup.app.estore.shoppingcart.ShoppingCart;

public class Customer {
    private Integer id;

    private String name;

    private String password;

    private String zip;

    private String address;

    private String telephone;

    private String email;
    
    private List<Order> orders;
    
    private ShoppingCart shoppingcart;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
	public List<Order> getOrders() {
		if(orders == null) { orders = new ArrayList<>();}
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
	
	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public Customer() {
		super();
	}

	public Customer(Integer id, String name, String password, String zip, String address, String telephone,
			String email, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zip=" + zip + ", address="
				+ address + ", telephone=" + telephone + ", email=" + email + ", orders=" + orders + "]";
	}

    
    
}