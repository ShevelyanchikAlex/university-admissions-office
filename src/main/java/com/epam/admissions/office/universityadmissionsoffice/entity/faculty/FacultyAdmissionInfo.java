package com.epam.admissions.office.universityadmissionsoffice.entity.faculty;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class FacultyAdmissionInfo implements Serializable {
    private int facultyAdmissionInfoId;
    private double passingScore;
    private int places;
    private Date year;
    private int facultyId;

    public FacultyAdmissionInfo() {
    }

    public FacultyAdmissionInfo(int facultyAdmissionInfoId, double passingScore, int places, Date year, int facultyId) {
        this.facultyAdmissionInfoId = facultyAdmissionInfoId;
        this.passingScore = passingScore;
        this.places = places;
        this.year = year;
        this.facultyId = facultyId;
    }

    public int getFacultyAdmissionInfoId() {
        return facultyAdmissionInfoId;
    }

    public void setFacultyAdmissionInfoId(int facultyAdmissionInfoId) {
        this.facultyAdmissionInfoId = facultyAdmissionInfoId;
    }

    public double getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(double passingScore) {
        this.passingScore = passingScore;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
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
        FacultyAdmissionInfo that = (FacultyAdmissionInfo) o;
        return facultyAdmissionInfoId == that.facultyAdmissionInfoId && Double.compare(that.passingScore, passingScore) == 0 && places == that.places && facultyId == that.facultyId && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyAdmissionInfoId, passingScore, places, year, facultyId);
    }

    @Override
    public String toString() {
        return "FacultyAdmissionInfo{" +
                "facultyAdmissionInfoId=" + facultyAdmissionInfoId +
                ", passingScore=" + passingScore +
                ", places=" + places +
                ", year=" + year +
                ", facultyId=" + facultyId +
                '}';
    }

}
