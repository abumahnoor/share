package pk.share.fms.yess.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "YESS_VOLUNTEER")
@Entity(name = "yess$Volunteer")
public class Volunteer extends StandardEntity {
    private static final long serialVersionUID = -7613477119072604944L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "ADDRESS_LINE1")
    protected String addressLine1;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }


}