package carrefour.portailrh.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Employee extends User{

    private long cin;

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

}
