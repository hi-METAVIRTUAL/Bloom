package com.metavirtual.bloom.myPage.therapistPage.model.dto;

public class DataFileDTO {
    private int fileNumber;
    private String filePath;
    private String userId;
    private String fileOriginName;
    private String fileChangedName;
    private int fileSize;

    public DataFileDTO() {
    }

    public DataFileDTO(int fileNumber, String filePath, String userId, String fileOriginName, String fileChangedName, int fileSize) {
        this.fileNumber = fileNumber;
        this.filePath = filePath;
        this.userId = userId;
        this.fileOriginName = fileOriginName;
        this.fileChangedName = fileChangedName;
        this.fileSize = fileSize;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(int fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileOriginName() {
        return fileOriginName;
    }

    public void setFileOriginName(String fileOriginName) {
        this.fileOriginName = fileOriginName;
    }

    public String getFileChangedName() {
        return fileChangedName;
    }

    public void setFileChangedName(String fileChangedName) {
        this.fileChangedName = fileChangedName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "DataFileDTO{" +
                "fileNumber=" + fileNumber +
                ", filePath='" + filePath + '\'' +
                ", userId='" + userId + '\'' +
                ", fileOriginName='" + fileOriginName + '\'' +
                ", fileChangedName='" + fileChangedName + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
