package com.wping.seed.enums;

public enum NasDirTypeEnum {

    ;

    private String name;
    private String dir;
    private String desc;


    NasDirTypeEnum(String name, String dir, String desc) {
        this.desc = desc;
        this.dir = dir;
        this.name = name;
    }

    public static NasDirTypeEnum getNasDirTypeEnumByName(String name) {

        if (name != null) {
            for (NasDirTypeEnum nasDirTypeEnum : NasDirTypeEnum.values()) {
                if (name.equals(nasDirTypeEnum.getName())) {
                    return nasDirTypeEnum;
                }
            }
        }
        return null;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
