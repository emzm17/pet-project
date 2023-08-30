package com.amdocs.petstore.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.amdocs.petstore.dao.PetDaoImp;
import com.amdocs.petstore.model.Pet;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in); 
			PetDaoImp petdaompl=new PetDaoImp();
			
			
            int choice;
            do {
            	System.out.println("Enter your Choice");
            	System.out.println("1 Add new pet details");
            	System.out.println("2 Update pet price and Vaccination status");
            	System.out.println("3 Delete pet details");
            	System.out.println("4 View all pets");
            	System.out.println("5 Count pets by category");
            	System.out.println("6 Find by price");
            	System.out.println("7 Find by vaccination count for pet type");
            	System.out.println("8 Exit");
            	choice=sc.nextInt();
            	
            	switch(choice){
            	case 1:
        
            	    System.out.println("Enter petId");
            		int petId=sc.nextInt();
            		System.out.println("Enter pet Category");
            		String petcategory=sc.next();
            		System.out.println("Enter pet Type");
            		String pettype=sc.next();
            		System.out.println("Enter pet color");
            		String petcolor=sc.next();
            		System.out.println("Enter pet age");
            		int petage=sc.nextInt();
            		System.out.println("Enter pet Price");
            		double petprice=sc.nextDouble();
            		System.out.println("Is- Vaccinated");
            		int petvaccinated=sc.nextInt();
            		
            		System.out.println("Enter pet Food habits");
            		String petfoodhabits=sc.next();
            		Pet p=new Pet(petId,petcategory,pettype,petcolor,petage,petprice,petvaccinated,petfoodhabits);
            		System.out.println(petdaompl.addPetDetails(p));
            		break;
            	case 2:
            		System.out.println("Enter new price");
            		double pprice=sc.nextDouble();
            		System.out.println("Enter new Vaccination status");
            		int pvaccinated=sc.nextInt();
            		
            		System.out.println("Enter pet id");
            		int petid=sc.nextInt();
            		if(petdaompl.updatePetPriceAndVaccinationStatus(pprice,pvaccinated,petid)) {
            			System.out.println("pet details Updated is successfully");
            		}
            		else {
            			System.out.println("pet details Updated is successfully");
            		}
            		break;
            	case 3:
            		System.out.println("Enter pet id which want to delete");
            		int pid=sc.nextInt();
            		System.out.println(petdaompl.deletePetDetails(pid));
            		break;
            	case 4:
            		System.out.println("All pet details");
            		
            		List<Pet> list=petdaompl.showAllPets();
            		for(int i=0;i<list.size();i++) {
            			 System.out.println(list.get(i));
            		}
//            		System.out.println(list.size());
            		break;
            	case 5:
            		System.out.println("Enter pet category to count");
            		String pcategory=sc.next();
            		System.out.println("Number of pets in this category is "+pcategory+":"+
            		petdaompl.countPetsByCategory(pcategory));
            		break;
            	case 6:
            		System.out.println("Enter minimum price");
            		double price1=sc.nextDouble();
            		System.out.println("Enter maximun price");
            		double price2=sc.nextDouble();
            		List list1=petdaompl.searchByPrice(price1,price2);
            		for(int i=0;i<list1.size();i++) {
            			System.out.println(list1.get(i));
            		}
            		if(list1.size()==0) {
            			System.out.println("No pet is found within this range");
            		}
                    break;
            	case 7:
            		System.out.println("Enter pet type");
            		String petytpe=sc.next();
            
            		System.out.println("Number of vaccinated pet for this type is "+": "+
            		petdaompl.countByVaccinationStatusForPetType(petytpe));
            	    break;
            	case 8:
            		System.out.println("Exiting..");
            		break;
            	default:
            		System.out.println("Invalid Choice");
            		break;
            	}
           	
            	
          		
            }while(choice!=8);
	}
}
