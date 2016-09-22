package pk.share.fms.yess.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|incidentName")
@Table(name = "YESS_INCIDENT")
@Entity(name = "yess$Incident")
public class Incident extends StandardEntity {
    private static final long serialVersionUID = 2750831938949650871L;

    @Temporal(TemporalType.DATE)
    @Column(name = "INCIDENT_DATE", nullable = false)
    protected Date incidentDate;

    @Column(name = "INCIDENT_NAME", nullable = false)
    protected String incidentName;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INCIDENT_REGION_ID")
    protected Region incidentRegion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INCIDENT_CITY_ID")
    protected City incidentCity;

    @Column(name = "INCIDENT_LOCATION", nullable = false)
    protected String incidentLocation;

    public void setIncidentName(String incidentName) {
        this.incidentName = incidentName;
    }

    public String getIncidentName() {
        return incidentName;
    }


    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }


    public void setIncidentCity(City incidentCity) {
        this.incidentCity = incidentCity;
    }

    public City getIncidentCity() {
        return incidentCity;
    }


    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setIncidentRegion(Region incidentRegion) {
        this.incidentRegion = incidentRegion;
    }

    public Region getIncidentRegion() {
        return incidentRegion;
    }


}