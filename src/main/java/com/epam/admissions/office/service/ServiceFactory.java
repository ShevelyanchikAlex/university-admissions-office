package com.epam.admissions.office.service;

import com.epam.admissions.office.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private static final UserService userService = new UserServiceImpl();
    private static final FacultyService facultyService = new FacultyServiceImpl();
    private static final SubjectService subjectService = new SubjectServiceImpl();
    private static final ResultService resultService = new ResultServiceImpl();
    private static final FacultyAdmissionInfoService facultyAdmissionInfoService = new FacultyAdmissionInfoServiceImpl();
    private static final ApplicationService applicationService = new ApplicationServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public FacultyService getFacultyService() {
        return facultyService;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public ResultService getResultService() {
        return resultService;
    }

    public FacultyAdmissionInfoService getFacultyAdmissionInfoService() {
        return facultyAdmissionInfoService;
    }

    public ApplicationService getApplicationService() {
        return applicationService;
    }

}
