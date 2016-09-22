package pk.share.fms.yess.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Regions implements EnumClass<Integer> {

    Sindh(1),
    KhyberPakhtunkhwa(2),
    Baluchistan(3),
    Punjab(4),
    FATA(5),
    AJK(6),
    Gilgit(7),
    Islamabad(8);

    private Integer id;

    Regions(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static Regions fromId(Integer id) {
        for (Regions at : Regions.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}