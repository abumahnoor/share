package pk.share.fms.yess.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ApplicationStatus implements EnumClass<String> {

    Submitted("S"),
    Approved("A"),
    Declined("D");

    private String id;

    ApplicationStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ApplicationStatus fromId(String id) {
        for (ApplicationStatus at : ApplicationStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}