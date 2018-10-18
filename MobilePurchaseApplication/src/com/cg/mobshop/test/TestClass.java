package com.cg.mobshop.test;

import junit.framework.Assert;

import org.junit.Test;

import com.cg.mobshop.exception.PurchaseException;
import com.cg.mobshop.service.PurchaseService;
import com.cg.mobshop.service.PurchaseServiceImpl;

public class TestClass {

	@Test(expected=PurchaseException.class)
	public void test_ValidateName_null() throws PurchaseException{
		PurchaseService service=new PurchaseServiceImpl();
		service.validateName(null);
	}
	
	@Test
	public void test_validateName_v1() throws PurchaseException{
	
		String name="Aete121";
		PurchaseService service=new PurchaseServiceImpl();
		boolean result= service.validateName(name);
		Assert.assertEquals(false,result);
	}
	@Test
	public void test_validateName_v2() throws PurchaseException{
	
		String name="Amita";
		PurchaseService service=new PurchaseServiceImpl();
		boolean result= service.validateName(name);
		Assert.assertEquals(true,result);
	}
	@Test
	public void test_validateName_v3() throws PurchaseException{
	
		String name="amita";
		PurchaseService service=new PurchaseServiceImpl();
		boolean result= service.validateName(name);
		Assert.assertEquals(false,result);
	}
	
	
}
