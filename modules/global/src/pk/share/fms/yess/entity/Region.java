package pk.share.fms.yess.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|regionName")
@Table(name = "YESS_REGION")
@Entity(name = "yess$Region")
public class Region extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 1259617525259956073L;

    @Column(name = "REGION_NAME", nullable = false, unique = true, length = 50)
    protected String regionName;

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }


}