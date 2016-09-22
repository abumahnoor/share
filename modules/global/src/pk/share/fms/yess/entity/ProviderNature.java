package pk.share.fms.yess.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ProviderNature implements EnumClass<String> {

    VocationalTraining("T"),
    SecondarySchool("S"),
    HighSchool("H"),
    University("U");

    private String id;

    ProviderNature(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ProviderNature fromId(String id) {
        for (ProviderNature at : ProviderNature.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}