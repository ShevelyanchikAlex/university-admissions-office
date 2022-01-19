package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface ResultService {
    Result getResultById(int id) throws ServiceException;

    List<Result> getResultsByScore(double score) throws ServiceException;

    List<Result> getResultsBySubjectId(int subjectId) throws ServiceException;

    List<Result> getAllResults() throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int countAllResults() throws ServiceException;
}
