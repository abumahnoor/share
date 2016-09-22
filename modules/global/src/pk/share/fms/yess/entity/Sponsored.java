package pk.share.fms.yess.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Lob;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|firstName,lastName")
@Table(name = "YESS_SPONSORED")
@Entity(name = "yess$Sponsored")
public class Sponsored extends StandardEntity {
    private static final long serialVersionUID = -4280809017385141502L;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    protected String firstName;

    @Column(name = "LAST_NAME", length = 100)
    protected String lastName;

    @Column(name = "GENDER", nullable = false)
    protected String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE", nullable = false)
    protected Date birthDate;

    @Column(name = "IS_SYED")
    protected Boolean isSyed;

    @Column(name = "ADDRESS_LINE1", length = 100)
    protected String addressLine1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Column(name = "POSTAL_CODE", length = 7)
    protected String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAMILY_ID")
    protected Family family;

    @Column(name = "CONTACT_PHONE", length = 15)
    protected String contactPhone;

    @Lob
    @Column(name = "ADDITIONAL_CONTACTS")
    protected String additionalContacts;

    @Column(name = "IS_ACTIVE", nullable = false)
    protected Boolean isActive = false;

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsActive() {
        return isActive;
    }


    public void setGender(Gender gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public Gender getGender() {
        return gender == null ? null : Gender.fromId(gender);
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setAdditionalContacts(String additionalContacts) {
        this.additionalContacts = additionalContacts;
    }

    public String getAdditionalContacts() {
        return additionalContacts;
    }


    public void setFamily(Family family) {
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setIsSyed(Boolean isSyed) {
        this.isSyed = isSyed;
    }

    public Boolean getIsSyed() {
        return isSyed;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }


}