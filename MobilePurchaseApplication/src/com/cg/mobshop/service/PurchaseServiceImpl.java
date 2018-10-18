package com.cg.mobshop.service;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mobshop.dao.PurchaseDAO;
import com.cg.mobshop.dao.PurchaseDetailsDaoImpl;
import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public class PurchaseServiceImpl implements PurchaseService {

	PurchaseDAO dao;
 public PurchaseServiceImpl() {
		 try {
			dao= new PurchaseDetailsDaoImpl();
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
	
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) throws PurchaseException {
		return dao.addPurchaseDetails(pr);
	}

	@Override
	public ArrayList<Mobile> getMobileList() throws PurchaseException {
		return dao.getMobileList();
	}

	@Override
	public ArrayList<Mobile> getMobileList(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mobile updateMobileDetails(Mobile mob) throws PurchaseException {
		return dao.updateMobileDetails(mob);
	}

	@Override
	public PurchaseDetails ValidateDetails(PurchaseDetails pd)
			throws PurchaseException {

			if(validateEmail(pd.getMailId()) &&
					 validateName(pd.getCustName()) && 
							 validatePhoneNo(pd.getPhoneNo()) )
			return pd;
			else
		return null;
	}

	@Override
	public boolean validateName(String name) throws PurchaseException {
		if(name==null)
			throw new PurchaseException("name can not be null");
		Pattern pat = Pattern.compile("[A-Z][a-z]{3,12}");
		Matcher mat= pat.matcher(name);
		return mat.matches();
	}

	@Override
	public boolean validatePhoneNo(String mob) {
		Pattern pat = Pattern.compile("[0-9]{10}");
		Matcher mat= pat.matcher(mob);
		return mat.matches();
	}

	@Override
	public boolean validateEmail(String email) {
		Pattern pat = Pattern.compile("[A-Za-z0-9]{2,15}@capgemini.com");
		Matcher mat= pat.matcher(email);
		return mat.matches();
	}

}
