package com.amdocs.petstore.dao;

import java.util.List;

import com.amdocs.petstore.exception.InvalidPriceException;
import com.amdocs.petstore.model.Pet;

public interface PetDAO {
       int addPetDetails(Pet p);
       int deletePetDetails(int id);
       boolean updatePetPriceAndVaccinationStatus(double price, int isVaccinated,int petId);
       List showAllPets();
       int countPetsByCategory(String s);
       List searchByPrice(double price1,double price2);
       int countByVaccinationStatusForPetType(String s);
       
       
}
