package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.FacultyAdmissionInfoDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;

import java.util.List;

public class FacultyAdmissionInfoImpl implements FacultyAdmissionInfoDao {
    private final QueryOperator<FacultyAdmissionInfo> queryOperator;

    public FacultyAdmissionInfoImpl() {
        RowMapper<FacultyAdmissionInfo> mapper = RowMapperFactory.getFacultiesAdmissionInfoRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }

    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_FACULTY_ADMISSION_INFO_BY_ID_QUERY, id);
    }

    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_FACULTY_ADMISSION_INFO_BY_FACULTY_ID_QUERY, facultyId);
    }

    @Override
    public List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_FACULTY_ADMISSION_INFOS_QUERY);
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_FACULTY_ADMISSION_INFOS_BY_PASSING_SCORE_QUERY, passingScore);
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_FACULTY_ADMISSION_INFOS_BY_PLACES_QUERY, places);
    }

    @Override
    public int deleteById(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.DELETE_FACULTY_ADMISSION_INFO_QUERY, id);
    }

    @Override
    public int updateFacultyAdmissionInfo(FacultyAdmissionInfo facultyAdmissionInfo) throws DaoException {
        return queryOperator.executeUpdate(
                DBRequest.UPDATE_FACULTY_ADMISSION_INFO_QUERY,
                facultyAdmissionInfo.getPassingScore(),
                facultyAdmissionInfo.getPlaces(),
                facultyAdmissionInfo.getYear(),
                facultyAdmissionInfo.getFacultyId(),
                facultyAdmissionInfo.getFacultyAdmissionInfoId());
    }

    @Override
    public int countAllAdmissionInfos() throws DaoException {
        return queryOperator.executeCountQuery(DBRequest.COUNT_ALL_FACULTY_ADMISSION_INFOS_QUERY);
    }
}
