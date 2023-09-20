package com.metavirtual.bloom.myPage.therapistPage.model.dto;

public class ProfileFileDTO {

    private int fileNumber;
    private String userId;
    private String filePath;
    private String fileOriginName;
    private String fileChangedName;
    private int fileSize;

    public ProfileFileDTO() {
    }

    public ProfileFileDTO(int fileNumber, String userId, String filePath, String fileOriginName, String fileChangedName, int fileSize) {
        this.fileNumber = fileNumber;
        this.userId = userId;
        this.filePath = filePath;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
        return "ProfileFileDTO{" +
                "fileNumber=" + fileNumber +
                ", userId='" + userId + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileOriginName='" + fileOriginName + '\'' +
                ", fileChangedName='" + fileChangedName + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
