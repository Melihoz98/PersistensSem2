package model;

public class Supplier {
	

private int ID;
private String name;
private String streetName;
private int houseNo;
private int zipCode;



public Supplier() {
 
}


public Supplier(int ID, String name, String streetName, int houseNo, int zipCode) {
    this.ID = ID;
    this.name = name;
    this.streetName = streetName;
    this.houseNo = houseNo;
    this.zipCode = zipCode;
}



public int getID() {
    return ID;
}

public void setID(int ID) {
    this.ID = ID;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getStreetName() {
    return streetName;
}

public void setStreetName(String streetName) {
    this.streetName = streetName;
}

public int getHouseNo() {
    return houseNo;
}

public void setHouseNo(int houseNo) {
    this.houseNo = houseNo;
}

public int getZipCode() {
    return zipCode;
}

public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
}

}
