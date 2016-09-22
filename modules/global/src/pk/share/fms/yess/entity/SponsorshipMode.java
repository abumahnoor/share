package pk.share.fms.yess.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum SponsorshipMode implements EnumClass<String> {

    EarlyEducation("E"),
    FinancialSupport("F"),
    Training("T"),
    College("C");

    private String id;

    SponsorshipMode(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static SponsorshipMode fromId(String id) {
        for (SponsorshipMode at : SponsorshipMode.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}