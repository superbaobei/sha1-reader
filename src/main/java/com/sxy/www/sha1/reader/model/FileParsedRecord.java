package com.sxy.www.sha1.reader.model.115.model;

public class FileParsedRecord {
    private Integer id;

    private String parentFile;

    private String fileDigest;

    public FileParsedRecord(Integer id, String parentFile, String fileDigest) {
        this.id = id;
        this.parentFile = parentFile;
        this.fileDigest = fileDigest;
    }

    public FileParsedRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentFile() {
        return parentFile;
    }

    public void setParentFile(String parentFile) {
        this.parentFile = parentFile == null ? null : parentFile.trim();
    }

    public String getFileDigest() {
        return fileDigest;
    }

    public void setFileDigest(String fileDigest) {
        this.fileDigest = fileDigest == null ? null : fileDigest.trim();
    }
}