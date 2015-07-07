package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Office {

    public Office(){

    }

    public Office(String id, String name, String zipCode, String city, String street, String telephone,
                  String openingHours, String imageUrl, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.telephone = telephone;
        this.openingHours = openingHours;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("DisKz")
	public String id;

    @JsonProperty("DisNameLang")
    public String name;

    @JsonProperty("DisPlz")
    public String zipCode;

    @JsonProperty("DisOrt")
    public String city;

    @JsonProperty("DisStrasse")
    public String street;

    @JsonProperty("DisTel")
    public String telephone;

    @JsonProperty("DisOeffnung")
    public String openingHours;

    @JsonProperty("DisFotoUrl")
    public String imageUrl;

    @JsonProperty("DisLatitude")
    public String latitude;

    @JsonProperty("DisLongitude")
    public String longitude;
}
