package application.domain;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eqpId;
    private String name;
    private String producer;
    private Date date_produce;
    private String status;

    public Equipment(String name, String producer, Date date_produce) {
        this.name = name;
        this.producer = producer;
        this.date_produce = date_produce;
        this.status = "Not work";
    }

    public Long getEqpId() {
        return eqpId;
    }

    public void setEqpId(Long eqpId) {
        this.eqpId = eqpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getDate_produce() {
        return date_produce;
    }

    public void setDate_produce(Date date_produce) {
        this.date_produce = date_produce;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
