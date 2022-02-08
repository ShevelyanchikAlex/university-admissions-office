package com.epam.admissions.office.entity;

import java.io.Serializable;
import java.util.Objects;

public class Result implements Serializable {
    private int resultId;
    private int certificateId;
    private int applicationId;
    private int subjectId;
    private double score;
    private boolean isCertificateConfirmed;
    private String certificateImageUrl;

    public Result() {
    }

    public Result(int resultId, double score, int certificateId, String certificateImageUrl,
                  boolean isCertificateConfirmed, int applicationId, int subjectId) {
        this.resultId = resultId;
        this.score = score;
        this.certificateId = certificateId;
        this.certificateImageUrl = certificateImageUrl;
        this.isCertificateConfirmed = isCertificateConfirmed;
        this.applicationId = applicationId;
        this.subjectId = subjectId;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateImageUrl() {
        return certificateImageUrl;
    }

    public void setCertificateImageUrl(String certificateImageUrl) {
        this.certificateImageUrl = certificateImageUrl;
    }

    public boolean isCertificateConfirmed() {
        return isCertificateConfirmed;
    }

    public void setCertificateConfirmed(boolean certificateConfirmed) {
        isCertificateConfirmed = certificateConfirmed;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return resultId == result.resultId && Double.compare(result.score, score) == 0 && certificateId == result.certificateId && isCertificateConfirmed == result.isCertificateConfirmed && applicationId == result.applicationId && subjectId == result.subjectId && Objects.equals(certificateImageUrl, result.certificateImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultId, score, certificateId, certificateImageUrl, isCertificateConfirmed, applicationId, subjectId);
    }


    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", score=" + score +
                ", certificateId=" + certificateId +
                ", certificateImageUrl='" + certificateImageUrl + '\'' +
                ", isCertificateConfirmed=" + isCertificateConfirmed +
                ", applicationId=" + applicationId +
                ", subjectId=" + subjectId +
                '}';
    }
}
