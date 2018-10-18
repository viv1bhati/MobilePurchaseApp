package com.cg.mobshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public class PurchaseDetailsDaoImpl  implements PurchaseDAO{

	Connection connection;
	public PurchaseDetailsDaoImpl() throws PurchaseException{
		connection= DBConnection.getConnection();
	}
	public int generateId(){
		int id=0;
		try {
			Statement stmt= connection.createStatement();
			ResultSet rs= 
		stmt.executeQuery("select id_gen.nextval from dual");
			if(rs.next())
			{
				id= rs.getInt(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return id;
	}
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) throws PurchaseException {

		String sql="insert into purchaseDetails values"
				+ "(?,?,?,?,sysdate,?)";
		try {
			PreparedStatement ps=
				connection.prepareStatement(sql);
			int	id= generateId();
			ps.setInt(1,id);
			ps.setString(2,pr.getCustName());
			ps.setString(3,pr.getMailId());
			ps.setString(4,pr.getPhoneNo());
			ps.setInt(5,pr.getMobileId());
		
			int rowcount=ps.executeUpdate();
			if(rowcount==1)
			return id;
		
		} catch (SQLException e) {
		throw new PurchaseException(e.getMessage());
		}
		return 0;
	}
	@Override
	public ArrayList<Mobile> getMobileList() {
		ArrayList<Mobile> list= new ArrayList<>();
		String sql="select mobileid,name,price,quantity from mobiles";
		try {
			Statement st= connection.createStatement();
			ResultSet rs= st.executeQuery(sql);
				
			while(rs.next()){
				Mobile mob= new Mobile();
				mob.setMobileId(rs.getInt("mobileid"));
				mob.setName(rs.getString("name"));
				mob.setPrice(rs.getDouble("price"));
				mob.setQuantity(rs.getInt("quantity"));
				
				list.add(mob);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ArrayList<Mobile> getMobileList(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Mobile updateMobileDetails(Mobile mob) {
		
		String sql= " update mobiles "
				+ "  set price=?, "
				+ " quantity=? where mobileid=? ";
		
		try {
			PreparedStatement ps= connection.prepareStatement(sql);
		
			ps.setDouble(1, mob.getPrice());
			ps.setInt(2,mob.getQuantity());
			ps.setInt(3, mob.getMobileId());
		
			int rowcount= ps.executeUpdate();
			if(rowcount==0)
				throw new PurchaseException("mobile id is invalid ");
			return mob; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return null;
	}

}











