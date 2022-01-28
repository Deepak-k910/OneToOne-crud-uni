package com.ty.onetoone.controller;

import com.ty.dto.Invoice;
import com.ty.dto.Item;
import com.ty.dto.Item_InvoiceDao;


public class Item_InvoiceController {
	public static void main(String[] args) {
//	  Item item=new Item();
//	  item.setId(3);
//	  item.setName("Lap");
//	  item.setCost(50000);
//	  item.setQunatity(1);
//	  Invoice invoice=new Invoice();
//	  invoice.setId(3);
//	  invoice.setName("Deepak");
//	  invoice.setBillingAddress("blr-123");
//	  invoice.setGstNumber("fstr ytetdo");
//	  invoice.setTax(18);
//	  invoice.setItems(item);
	  Item_InvoiceDao dao=new  Item_InvoiceDao();
//	  dao.save(invoice, item);
	  Invoice invoice=dao.get(3);
	  if(invoice!=null)
	  {
		  System.out.println(invoice.getId());
		  System.out.println(invoice.getName());
		  System.out.println(invoice.getBillingAddress());
		  System.out.println(invoice.getGstNumber());
		  System.out.println(invoice.getTax());
		  Item item=invoice.getItems();
		  System.out.println(item.getId());
		  System.out.println(item.getName());
		  
	  }
		
	  
	}

}
