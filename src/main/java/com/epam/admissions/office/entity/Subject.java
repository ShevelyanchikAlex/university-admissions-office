package com.epam.admissions.office.entity;

import java.io.Serializable;
import java.util.Objects;

public class Subject implements Serializable {
    private int subjectId;
    private String subjectName;
    private String subjectShortName;

    public Subject() {
    }

    public Subject(int subjectId, String subjectName, String subjectShortName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectShortName = subjectShortName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectShortName() {
        return subjectShortName;
    }

    public void setSubjectShortName(String subjectShortName) {
        this.subjectShortName = subjectShortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId && Objects.equals(subjectName, subject.subjectName) && Objects.equals(subjectShortName, subject.subjectShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectName, subjectShortName);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectShortName='" + subjectShortName + '\'' +
                '}';
    }
}
