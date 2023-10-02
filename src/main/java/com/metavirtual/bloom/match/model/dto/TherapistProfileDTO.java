package com.metavirtual.bloom.match.model.dto;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public class TherapistProfileDTO {
    private String userId;
    private String therapistQ1;
    private String therapistQ2;
    private String therapistQ3;
    private char activationStatus;
    private char confirmedStatus;
    private char sessionVidCallCK;
    private char sessionChatCK;
    private char sessionInPersonCK;
    private char depressionCK;
    private char anxietyCK;
    private char bipolarCK;
    private char ocdCK;
    private char relationCK;
    private String organization;
    private UserDTO name;
    private UserDTO gender;
    private UserDTO phone;
    private ProfileFileDTO filePath;

    private ReviewDTO reviewScore;
    private ReviewDTO reviewContent;

    public TherapistProfileDTO() {
    }

    public TherapistProfileDTO(String userId, String therapistQ1, String therapistQ2, String therapistQ3, char activationStatus, char confirmedStatus, char sessionVidCallCK, char sessionChatCK, char sessionInPersonCK, char depressionCK, char anxietyCK, char bipolarCK, char ocdCK, char relationCK, String organization, UserDTO name, UserDTO gender, UserDTO phone, ProfileFileDTO filePath, ReviewDTO reviewScore, ReviewDTO reviewContent) {
        this.userId = userId;
        this.therapistQ1 = therapistQ1;
        this.therapistQ2 = therapistQ2;
        this.therapistQ3 = therapistQ3;
        this.activationStatus = activationStatus;
        this.confirmedStatus = confirmedStatus;
        this.sessionVidCallCK = sessionVidCallCK;
        this.sessionChatCK = sessionChatCK;
        this.sessionInPersonCK = sessionInPersonCK;
        this.depressionCK = depressionCK;
        this.anxietyCK = anxietyCK;
        this.bipolarCK = bipolarCK;
        this.ocdCK = ocdCK;
        this.relationCK = relationCK;
        this.organization = organization;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.filePath = filePath;
        this.reviewScore = reviewScore;
        this.reviewContent = reviewContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTherapistQ1() {
        return therapistQ1;
    }

    public void setTherapistQ1(String therapistQ1) {
        this.therapistQ1 = therapistQ1;
    }

    public String getTherapistQ2() {
        return therapistQ2;
    }

    public void setTherapistQ2(String therapistQ2) {
        this.therapistQ2 = therapistQ2;
    }

    public String getTherapistQ3() {
        return therapistQ3;
    }

    public void setTherapistQ3(String therapistQ3) {
        this.therapistQ3 = therapistQ3;
    }

    public char getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(char activationStatus) {
        this.activationStatus = activationStatus;
    }

    public char getConfirmedStatus() {
        return confirmedStatus;
    }

    public void setConfirmedStatus(char confirmedStatus) {
        this.confirmedStatus = confirmedStatus;
    }

    public char getSessionVidCallCK() {
        return sessionVidCallCK;
    }

    public void setSessionVidCallCK(char sessionVidCallCK) {
        this.sessionVidCallCK = sessionVidCallCK;
    }

    public char getSessionChatCK() {
        return sessionChatCK;
    }

    public void setSessionChatCK(char sessionChatCK) {
        this.sessionChatCK = sessionChatCK;
    }

    public char getSessionInPersonCK() {
        return sessionInPersonCK;
    }

    public void setSessionInPersonCK(char sessionInPersonCK) {
        this.sessionInPersonCK = sessionInPersonCK;
    }

    public char getDepressionCK() {
        return depressionCK;
    }

    public void setDepressionCK(char depressionCK) {
        this.depressionCK = depressionCK;
    }

    public char getAnxietyCK() {
        return anxietyCK;
    }

    public void setAnxietyCK(char anxietyCK) {
        this.anxietyCK = anxietyCK;
    }

    public char getBipolarCK() {
        return bipolarCK;
    }

    public void setBipolarCK(char bipolarCK) {
        this.bipolarCK = bipolarCK;
    }

    public char getOcdCK() {
        return ocdCK;
    }

    public void setOcdCK(char ocdCK) {
        this.ocdCK = ocdCK;
    }

    public char getRelationCK() {
        return relationCK;
    }

    public void setRelationCK(char relationCK) {
        this.relationCK = relationCK;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public UserDTO getName() {
        return name;
    }

    public void setName(UserDTO name) {
        this.name = name;
    }

    public UserDTO getGender() {
        return gender;
    }

    public void setGender(UserDTO gender) {
        this.gender = gender;
    }

    public UserDTO getPhone() {
        return phone;
    }

    public void setPhone(UserDTO phone) {
        this.phone = phone;
    }

    public ProfileFileDTO getFilePath() {
        return filePath;
    }

    public void setFilePath(ProfileFileDTO filePath) {
        this.filePath = filePath;
    }

    public ReviewDTO getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(ReviewDTO reviewScore) {
        this.reviewScore = reviewScore;
    }

    public ReviewDTO getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(ReviewDTO reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "TherapistProfile{" +
                "userId='" + userId + '\'' +
                ", therapistQ1='" + therapistQ1 + '\'' +
                ", therapistQ2='" + therapistQ2 + '\'' +
                ", therapistQ3='" + therapistQ3 + '\'' +
                ", activationStatus=" + activationStatus +
                ", confirmedStatus=" + confirmedStatus +
                ", sessionVidCallCK=" + sessionVidCallCK +
                ", sessionChatCK=" + sessionChatCK +
                ", sessionInPersonCK=" + sessionInPersonCK +
                ", depressionCK=" + depressionCK +
                ", anxietyCK=" + anxietyCK +
                ", bipolarCK=" + bipolarCK +
                ", ocdCK=" + ocdCK +
                ", relationCK=" + relationCK +
                ", organization='" + organization + '\'' +
                ", name=" + name +
                ", gender=" + gender +
                ", phone=" + phone +
                ", filePath=" + filePath +
                ", reviewScore=" + reviewScore +
                ", reviewContent=" + reviewContent +
                '}';
    }
}
