package com.urise.webapp.model;

/**
 * com.urise.webapp.model.Resume class
 */
public class Resume {
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    // Unique identifier


    @Override
    public String toString() {
        return uuid;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this==obj)return true;
//        if (obj==null||getClass()!=obj.getClass())return false;
//    }
}
