package com.amdocs.petstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.petstore.model.Pet;

public class PetDaoImp implements PetDAO {
	DBConnection db=new DBConnection();
	Connection c=db. getConnection();
	

	@Override
	public int addPetDetails(Pet p) {
		 int count=0;
		 try {
			 PreparedStatement pst=c.prepareStatement("insert into table1 values(?,?,?,?,?,?,?,?)");
			 pst.setInt(1,p.getPedId());
			 pst.setString(2, p.getPetCategory());
			 pst.setString(3, p.getPetType());
			 pst.setString(4, p.getColor());
			 pst.setInt(5, p.getAge());
			 pst.setDouble(6, p.getPrice());
			 pst.setInt(7,p.getVaccinated());
			 pst.setString(8, p.getFoodHabits());
			 count=pst.executeUpdate();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		return count;
		
	
	}

	@Override
	public int deletePetDetails(int id) {
		
		int count=0;
		 try {
			 PreparedStatement pst=c.prepareStatement("delete from table1 where PetId=?");
			 pst.setInt(1,id);
			 count=pst.executeUpdate();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		return count;
	}

	
	

	@Override
	public List showAllPets() {
		List<Pet> list=new ArrayList();
		try {
			 PreparedStatement pst=c.prepareStatement("select * from table1");
			 ResultSet res=pst.executeQuery();
			 while(res.next()) {
				
				 Pet pet=new Pet(res.getInt("petId"),res.getString("petCategory"),res.getString("petType"),
						 res.getString("color"),res.getInt("age"),res.getDouble("price"),res.getInt("isVaccinated"),
						 res.getString("foodHabits"));
				 
				 list.add(pet);
			 }
		}catch(SQLException e) {
			 e.printStackTrace();
		 }
		return list;
	}

	@Override
	public int countPetsByCategory(String s) {
		List<Pet> list=new ArrayList();
		try {
			 PreparedStatement pst=c.prepareStatement("select * from table1 where petCategory=?");
			 pst.setString(1,s);
			 ResultSet res=pst.executeQuery();
			 while(res.next()) {
				
				 Pet pet=new Pet(res.getInt("petId"),res.getString("petCategory"),res.getString("petType"),
						 res.getString("color"),res.getInt("age"),res.getDouble("price"),res.getInt("isVaccinated"),
						 res.getString("foodHabits"));
				 
				 list.add(pet);
			 }
		}catch(SQLException e) {
			 e.printStackTrace();
		 }
		return list.size();
	}

	@Override
	public boolean updatePetPriceAndVaccinationStatus(double price, int isVaccinated, int petId) {
		try {
			PreparedStatement pst=c.prepareStatement("update table1 set price=?,isVaccinated=? where petId=?");
		    pst.setDouble(1, price);
			pst.setInt(2, isVaccinated);
			pst.setInt(3, petId);
			pst.executeUpdate();
		    return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List searchByPrice(double price1, double price2) {
		List<Pet> list=new ArrayList();
		try {
			 PreparedStatement pst=c.prepareStatement("select * from table1 where price between ? and ?");
			 pst.setDouble(1, price1);
			 pst.setDouble(2, price2);
			 ResultSet res=pst.executeQuery();
			 while(res.next()) {
				
				 Pet pet=new Pet(res.getInt("petId"),res.getString("petCategory"),res.getString("petType"),
						 res.getString("color"),res.getInt("age"),res.getDouble("price"),res.getInt("isVaccinated"),
						 res.getString("foodHabits"));
				 
				 list.add(pet);
			 }
		}catch(SQLException e) {
			 e.printStackTrace();
		 }
		return list;
	}

	@Override
	public int countByVaccinationStatusForPetType(String s) {
		List list=new ArrayList();
		try {
			 PreparedStatement pst=c.prepareStatement("select * from table1 where petType=?");
			 pst.setString(1,s);
			 ResultSet res=pst.executeQuery();
			 while(res.next()) {
				
				 Pet pet=new Pet(res.getInt("petId"),res.getString("petCategory"),res.getString("petType"),
						 res.getString("color"),res.getInt("age"),res.getDouble("price"),res.getInt("isVaccinated"),
						 res.getString("foodHabits"));
				 
				 if(pet.getVaccinated()==1) {
					 list.add(pet);
				 }
				 
			 }
		}catch(SQLException e) {
			 e.printStackTrace();
		 }
		return list.size();
	}

	}




