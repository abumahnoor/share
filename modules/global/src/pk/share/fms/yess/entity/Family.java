package pk.share.fms.yess.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|familyHeadName")
@Table(name = "YESS_FAMILY")
@Entity(name = "yess$Family")
public class Family extends StandardEntity {
    private static final long serialVersionUID = 2474513499923195512L;

    @Column(name = "FAMILY_HEAD_NAME", nullable = false)
    protected String familyHeadName;

    @Temporal(TemporalType.DATE)
    @Column(name = "FAMILY_HEAD_BIRTH_DATE")
    protected Date familyHeadBirthDate;

    @Column(name = "FAMILY_IDENTITY_CARD_NUMBER", nullable = false, length = 30)
    protected String familyIdentityCardNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "FAMILY_HEAD_DEATH_DATE")
    protected Date familyHeadDeathDate;

    @Column(name = "IS_SYED")
    protected Boolean isSyed;

    @Column(name = "STREE_ADDRESS")
    protected String streeAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Column(name = "POSTAL_CODE", length = 10)
    protected String postalCode;

    @Column(name = "CONTACT_PHONE", length = 15)
    protected String contactPhone;

    @Lob
    @Column(name = "ADDITIONAL_CONTACTS")
    protected String additionalContacts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEATH_IN_INCIDENT_ID")
    protected Incident deathInIncident;

    public void setDeathInIncident(Incident deathInIncident) {
        this.deathInIncident = deathInIncident;
    }

    public Incident getDeathInIncident() {
        return deathInIncident;
    }


    public void setIsSyed(Boolean isSyed) {
        this.isSyed = isSyed;
    }

    public Boolean getIsSyed() {
        return isSyed;
    }


    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() {
        return contactPhone;
    }


    public void setFamilyIdentityCardNumber(String familyIdentityCardNumber) {
        this.familyIdentityCardNumber = familyIdentityCardNumber;
    }

    public String getFamilyIdentityCardNumber() {
        return familyIdentityCardNumber;
    }


    public void setFamilyHeadDeathDate(Date familyHeadDeathDate) {
        this.familyHeadDeathDate = familyHeadDeathDate;
    }

    public Date getFamilyHeadDeathDate() {
        return familyHeadDeathDate;
    }


    public void setFamilyHeadBirthDate(Date familyHeadBirthDate) {
        this.familyHeadBirthDate = familyHeadBirthDate;
    }

    public Date getFamilyHeadBirthDate() {
        return familyHeadBirthDate;
    }


    public void setFamilyHeadName(String familyHeadName) {
        this.familyHeadName = familyHeadName;
    }

    public String getFamilyHeadName() {
        return familyHeadName;
    }

    public void setStreeAddress(String streeAddress) {
        this.streeAddress = streeAddress;
    }

    public String getStreeAddress() {
        return streeAddress;
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

    public void setAdditionalContacts(String additionalContacts) {
        this.additionalContacts = additionalContacts;
    }

    public String getAdditionalContacts() {
        return additionalContacts;
    }


}