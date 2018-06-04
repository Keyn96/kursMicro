package application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long worId;
    private String name;
    private Integer salary;
    private String contactNumber;
    private Date date_start_work;

    public Worker( String name, Integer salary, String contactNumber, Date date_start_work) {
        this.name = name;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.date_start_work = date_start_work;
    }

    public Long getWorId() {
        return worId;
    }

    public void setWorId(Long worId) {
        this.worId = worId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getDate_start_work() {
        return date_start_work;
    }

    public void setDate_start_work(Date date_start_work) {
        this.date_start_work = date_start_work;
    }
}
