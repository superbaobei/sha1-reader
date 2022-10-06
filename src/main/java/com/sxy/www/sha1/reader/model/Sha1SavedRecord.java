package com.sxy.www.sha1.reader.model;

public class Sha1SavedRecord {
    private Integer id;

    private String sha1;

    private String fileName;

    public Sha1SavedRecord(Integer id, String sha1, String fileName) {
        this.id = id;
        this.sha1 = sha1;
        this.fileName = fileName;
    }

    public Sha1SavedRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1 == null ? null : sha1.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }
}