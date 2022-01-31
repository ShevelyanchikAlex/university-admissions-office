package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface ResultService {
    boolean createResult(double score, int applicationId, int subjectId) throws ServiceException;

    boolean updateResult(int resultId, double score, int subjectId) throws ServiceException;

    Result getResultById(int id) throws ServiceException;

    List<Result> getResultsByScore(double score) throws ServiceException;

    List<Result> getResultsByApplicationId(int applicationId) throws ServiceException;

    List<Result> getResultsBySubjectId(int subjectId) throws ServiceException;

    List<Result> getAllResults() throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int countAllResults() throws ServiceException;
}
