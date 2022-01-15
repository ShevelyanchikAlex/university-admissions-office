package com.epam.admissions.office.universityadmissionsoffice.entity.faculty;

import java.io.Serializable;
import java.util.Objects;

public class Faculty implements Serializable {
    private int facultyId;
    private String facultyShortName;
    private String facultyName;
    private String facultyDescription;
    private String logoPictureUrl;


    public Faculty() {
    }

    public Faculty(int facultyId, String facultyShortName, String facultyName, String facultyDescription, String logoPictureUrl) {
        this.facultyId = facultyId;
        this.facultyShortName = facultyShortName;
        this.facultyName = facultyName;
        this.facultyDescription = facultyDescription;
        this.logoPictureUrl = logoPictureUrl;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyShortName() {
        return facultyShortName;
    }

    public void setFacultyShortName(String facultyShortName) {
        this.facultyShortName = facultyShortName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyDescription() {
        return facultyDescription;
    }

    public void setFacultyDescription(String facultyDescription) {
        this.facultyDescription = facultyDescription;
    }

    public String getLogoPictureUrl() {
        return logoPictureUrl;
    }

    public void setLogoPictureUrl(String logoPictureUrl) {
        this.logoPictureUrl = logoPictureUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyId == faculty.facultyId && Objects.equals(facultyShortName, faculty.facultyShortName) && Objects.equals(facultyName, faculty.facultyName) && Objects.equals(facultyDescription, faculty.facultyDescription) && Objects.equals(logoPictureUrl, faculty.logoPictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, facultyShortName, facultyName, facultyDescription, logoPictureUrl);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyShortName='" + facultyShortName + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", facultyDescription='" + facultyDescription + '\'' +
                ", logoPictureUrl='" + logoPictureUrl + '\'' +
                '}';
    }
}
