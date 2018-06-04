package application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FanBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fanId;
    private String name;
    private String pasprortNumber;


    public Long getFanId() {
        return fanId;
    }

    public void setFanId(Long fanId) {
        this.fanId = fanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasprortNumber() {
        return pasprortNumber;
    }

    public void setPasprortNumber(String pasprortNumber) {
        this.pasprortNumber = pasprortNumber;
    }
}
