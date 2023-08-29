package com.amdocs.petstore.model;

public class Pet {
 private  int petId;
 private String petCategory;
 @Override
public String toString() {
	return "Pet [pedId=" + petId + ", petCategory=" + petCategory + ", petType=" + petType + ", color=" + color
			+ ", age=" + age + ", price=" + price + ", isVaccinated=" + isVaccinated + ", foodHabits=" + foodHabits
			+ "]";
}
private String petType;
 private String color;
 private int age;
 
 
 
 

public Pet(int petId, String petCategory, String petType, String color, int age, double price, int isVaccinated,
		String foodHabits) {
	
	this.petId = petId;
	this.petCategory = petCategory;
	this.petType = petType;
	this.color = color;
	this.age = age;
	this.price = price;
	this.isVaccinated = isVaccinated;
	this.foodHabits = foodHabits;
}
public int getPedId() {
	return petId;
}
public void setPedId(int pedId) {
	this.petId = pedId;
}
public String getPetCategory() {
	return petCategory;
}
public void setPetCategory(String petCategory) {
	this.petCategory = petCategory;
}
public String getPetType() {
	return petType;
}
public void setPetType(String petType) {
	this.petType = petType;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getVaccinated() {
	return isVaccinated;
}
public void setVaccinated(int isVaccinated) {
	this.isVaccinated = isVaccinated;
}
public String getFoodHabits() {
	return foodHabits;
}
public void setFoodHabits(String foodHabits) {
	this.foodHabits = foodHabits;
}
 private double price;
 private int isVaccinated;
 private String foodHabits;
}
