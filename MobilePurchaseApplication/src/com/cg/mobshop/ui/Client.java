package com.cg.mobshop.ui;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.mobshop.dao.PurchaseDetailsDaoImpl;
import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;
import com.cg.mobshop.service.PurchaseService;
import com.cg.mobshop.service.PurchaseServiceImpl;


public class Client {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		PurchaseDetails pd= new PurchaseDetails();
		PurchaseService service= new PurchaseServiceImpl();
		do{
		System.out.println("Enter Customer name ");
		String name= sc.next();
		System.out.println("Enter phone no ");
		String phn= sc.next();
		System.out.println("Enter mail id ");
		String mail= sc.next();
		System.out.println("Enter mobile id ");
		int mobid= sc.nextInt();
		
		
		pd.setCustName(name);
		pd.setMailId(mail);
		pd.setMobileId(mobid);
		pd.setPhoneNo(phn);
		try {
			if( service.ValidateDetails(pd)!=null)
				break;
			else
				System.out.println("Invalid details entered...");
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(true);
		try {
			int purchaseid = service.addPurchaseDetails(pd);
			System.out.println("Record inserted..."+purchaseid);
	
		} catch (PurchaseException e) {
			System.out.println(e.getMessage());
		}
		/*
		ArrayList<Mobile> list= service.getMobileList();
		if(list.size()==0){
			System.err.println("No record Found");
		}
		else{
			for(Mobile mob : list){
				System.out.print(mob.getMobileId()+" ");
				System.out.print(mob.getName()+" " );
				System.out.print(mob.getQuantity()+" ");
			System.out.println(mob.getPrice());
			}
		}*/
		
		/*
		System.out.println("Enter Mobile id : ");
		int mobid= sc.nextInt();
		System.out.println("Enter Price");
		double pr= sc.nextDouble();
		System.out.println("Enter quantity ");
		int quantity= sc.nextInt();
		Mobile mobile= new Mobile ();
		mobile.setMobileId(mobid);
		mobile.setPrice(pr);
		mobile.setQuantity(quantity);
		
		try {
			mobile= service.updateMobileDetails(mobile);
			if(mobile!=null)
				System.out.println("Mobile details updated successfully.");
				
		} catch (PurchaseException e) {
		System.out.println(e.getMessage());
		}
		*/
		
		
		
		
		
		
		
		
		
}
}
