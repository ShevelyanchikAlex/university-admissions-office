package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.UserDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.UserService;
import com.epam.admissions.office.service.exception.ServiceException;
import com.epam.admissions.office.service.util.UtilFactory;
import com.epam.admissions.office.service.util.digest.PasswordDigest;
import com.epam.admissions.office.service.validator.Validator;
import com.epam.admissions.office.service.validator.ValidatorFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final int SUCCESSFUL_OPERATION = 1;

    @Override
    public User login(String email, String password) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        PasswordDigest passwordDigest = UtilFactory.getInstance().getPasswordDigest();
        User user = null;

        try {
            User dbUser = userDao.getByEmail(email);
            if (dbUser != null && dbUser.getPasswordHash().equals(passwordDigest.getDigestPassword(password)) && !dbUser.isDeleted()) {
                user = dbUser;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public boolean signUp(String name, String surname, String email, String passportId, String password, String confirmPassword) throws ServiceException {
        final int DEFAULT_USER_ID = 0;
        final boolean DEFAULT_IS_USER_DELETED = false;

        UserDao userDao = DaoFactory.getInstance().getUserDao();
        PasswordDigest passwordDigest = UtilFactory.getInstance().getPasswordDigest();

        User user = new User(DEFAULT_USER_ID, name, surname, passwordDigest.getDigestPassword(password), email, passportId, DEFAULT_IS_USER_DELETED, UserRole.USER_WITHOUT_APPLICATION);

        try {
            if (isUserDataValid(password, confirmPassword, user)) {
                return userDao.createUser(user) == SUCCESSFUL_OPERATION;
            } else {
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private boolean isUserDataValid(String password, String confirmPassword, User user) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator<User> userValidator = validatorFactory.getUserValidator();
        Validator<String> passwordValidator = validatorFactory.getPasswordValidator();

        return passwordValidator.validate(password) && password.equals(confirmPassword) && userValidator.validate(user);
    }

    @Override
    public User getById(int id) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.getUserById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User getByEmail(String email) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.getByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int restoreById(int id) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.restoreById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.getAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllUsers() throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.countAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllApplicants() throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.getAllApplicants();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllAdministrators() throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.getAllAdministrators();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public boolean editPersonalData(int id, String name, String surname, String email, String passportId) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator<User> userValidator = validatorFactory.getUserValidator();

        try {
            User user = userDao.getUserById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setPassportId(passportId);

            if (userValidator.validate(user)) {
                return userDao.updateUser(user) == SUCCESSFUL_OPERATION;
            } else {
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean changeUserRole(int id, UserRole userRole) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            User user = userDao.getUserById(id);
            user.setUserRole(userRole);

            return userDao.updateUser(user) == SUCCESSFUL_OPERATION;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsersByRoleId(int roleId) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.getUsersByRoleId(roleId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsersByStatus(String status) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.getUsersByStatus(status);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countByUserRole(UserRole userRole) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        try {
            return userDao.countByUserRole(userRole);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
