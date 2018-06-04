package application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Souvenir {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long souID;
    private String souName;
    private double souPrice;
    private int souCount;


   /* public Souvenir(String souName, double souPrice, int souCount) {
        this.souName = souName;
        this.souPrice = souPrice;
        this.souCount = souCount;
    }*/

    public Long getSouID() {
        return souID;
    }

    public void setSouID(Long souID) {
        this.souID = souID;
    }

    public String getSouName() {
        return souName;
    }

    public void setSouName(String souName) {
        this.souName = souName;
    }

    public double getSouPrice() {
        return souPrice;
    }

    public void setSouPrice(double souPrice) {
        this.souPrice = souPrice;
    }

    public int getSouCount() {
        return souCount;
    }

    public void setSouCount(int souCount) {
        this.souCount = souCount;
    }
}
