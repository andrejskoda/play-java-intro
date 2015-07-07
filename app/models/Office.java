package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Office {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public String id;

    public String name;

    public String zipCode;

    public String city;

    public String street;

    public String telephone;

    public String openingHours;

    public String imageUrl;

    public String latitude;

    public String longitude;
}
