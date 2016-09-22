package pk.share.fms.yess.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "YESS_PROVIDER")
@Entity(name = "yess$Provider")
public class Provider extends StandardEntity {
    private static final long serialVersionUID = 5890141865069237675L;

    @Column(name = "PROVIDER_NAME")
    protected String providerName;

    @Lob
    @Column(name = "PROVIDER_DESCRIPTION")
    protected String providerDescription;

    @Column(name = "ADDRESS_LINE1")
    protected String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    protected String addressLine2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Column(name = "NATURE_OF_PROVIDER")
    protected String natureOfProvider;

    @Column(name = "CONTACT_PHONE", length = 15)
    protected String contactPhone;

    @Lob
    @Column(name = "ADDITIONAL_CONTACTS")
    protected String additionalContacts;

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


    public void setNatureOfProvider(ProviderNature natureOfProvider) {
        this.natureOfProvider = natureOfProvider == null ? null : natureOfProvider.getId();
    }

    public ProviderNature getNatureOfProvider() {
        return natureOfProvider == null ? null : ProviderNature.fromId(natureOfProvider);
    }


    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderDescription(String providerDescription) {
        this.providerDescription = providerDescription;
    }

    public String getProviderDescription() {
        return providerDescription;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }


}