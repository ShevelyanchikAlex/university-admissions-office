package com.epam.admissions.office.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class Application implements Serializable {
    private int applicationId;
    private int userId;
    private int facultyId;
    private boolean isApproved;
    private String rejectionReason;
    private Date applyDate;
    private Date decisionDate;

    public Application() {
    }

    public Application(int applicationId, Date applyDate, boolean isApproved, Date decisionDate, String rejectionReason, int userId, int facultyId) {
        this.applicationId = applicationId;
        this.applyDate = applyDate;
        this.isApproved = isApproved;
        this.decisionDate = decisionDate;
        this.rejectionReason = rejectionReason;
        this.userId = userId;
        this.facultyId = facultyId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return applicationId == that.applicationId && isApproved == that.isApproved && userId == that.userId && facultyId == that.facultyId && Objects.equals(applyDate, that.applyDate) && Objects.equals(decisionDate, that.decisionDate) && Objects.equals(rejectionReason, that.rejectionReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, applyDate, isApproved, decisionDate, rejectionReason, userId, facultyId);
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", applyDate=" + applyDate +
                ", isApproved=" + isApproved +
                ", decisionDate=" + decisionDate +
                ", rejectionReason='" + rejectionReason + '\'' +
                ", userId=" + userId +
                ", facultyId=" + facultyId +
                '}';
    }
}
