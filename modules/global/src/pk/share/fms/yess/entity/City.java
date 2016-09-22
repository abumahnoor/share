package pk.share.fms.yess.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|cityName")
@Table(name = "YESS_CITY")
@Entity(name = "yess$City")
public class City extends StandardEntity {
    private static final long serialVersionUID = 7751418800443507111L;

    @Column(name = "CITY_NAME", nullable = false)
    protected String cityName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REGION_ID")
    protected Region region;

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }


}