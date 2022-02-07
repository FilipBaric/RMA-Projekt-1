package baric.projekt;

import java.io.Serializable;

// POJO
public class Uni implements Serializable {


    //Promjena imena klase i varijabli u ono sto vam API daje
    private String name; //ovo neka se vidi na listi
    private String country; //ovo neka se vidi na listi

    public Uni(String name, String country) {
        this.name = name;
        this.country = country;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
