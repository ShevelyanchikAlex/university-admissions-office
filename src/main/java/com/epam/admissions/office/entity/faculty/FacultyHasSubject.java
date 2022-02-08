package com.epam.admissions.office.entity.faculty;

import java.io.Serializable;

import java.sql.Date;
import java.util.Objects;

/**
 * FacultyHasSubject class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class FacultyHasSubject implements Serializable {
    private int facultyId;
    private int subjectId;
    private Date year;

    public FacultyHasSubject() {
    }

    public FacultyHasSubject(int facultyId, int subjectId, Date year) {
        this.facultyId = facultyId;
        this.subjectId = subjectId;
        this.year = year;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyHasSubject that = (FacultyHasSubject) o;
        return facultyId == that.facultyId && subjectId == that.subjectId && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, subjectId, year);
    }

    @Override
    public String toString() {
        return "FacultyHasSubject{" +
                "facultyId=" + facultyId +
                ", subjectId=" + subjectId +
                ", year=" + year +
                '}';
    }
}
