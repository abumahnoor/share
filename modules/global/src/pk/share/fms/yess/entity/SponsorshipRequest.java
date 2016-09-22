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

@Table(name = "YESS_SPONSORSHIP_REQUEST")
@Entity(name = "yess$SponsorshipRequest")
public class SponsorshipRequest extends StandardEntity {
    private static final long serialVersionUID = 6413054510725234869L;

    @Temporal(TemporalType.DATE)
    @Column(name = "REQUEST_DATE", nullable = false)
    protected Date requestDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APPLICANT_ID")
    protected Sponsored applicant;

    @Column(name = "NATURE", nullable = false)
    protected String nature;

    @Column(name = "REFERENCE_NAME")
    protected String referenceName;

    @Lob
    @Column(name = "REFERENCE_CONTACT")
    protected String referenceContact;

    @Column(name = "REUQEST_STATUS", nullable = false)
    protected String reuqestStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "STATUS_CHANGE_DATE")
    protected Date statusChangeDate;

    public void setReuqestStatus(ApplicationStatus reuqestStatus) {
        this.reuqestStatus = reuqestStatus == null ? null : reuqestStatus.getId();
    }

    public ApplicationStatus getReuqestStatus() {
        return reuqestStatus == null ? null : ApplicationStatus.fromId(reuqestStatus);
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public Date getStatusChangeDate() {
        return statusChangeDate;
    }


    public void setNature(SponsorshipMode nature) {
        this.nature = nature == null ? null : nature.getId();
    }

    public SponsorshipMode getNature() {
        return nature == null ? null : SponsorshipMode.fromId(nature);
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceContact(String referenceContact) {
        this.referenceContact = referenceContact;
    }

    public String getReferenceContact() {
        return referenceContact;
    }


    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setApplicant(Sponsored applicant) {
        this.applicant = applicant;
    }

    public Sponsored getApplicant() {
        return applicant;
    }


}