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
import com.epam.admissions.office.service.validator.constant.ValidPattern;

import java.util.List;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

    @Override
    public User login(String email, String password) throws ServiceException {
        PasswordDigest passwordDigest = UtilFactory.getInstance().getPasswordDigest();
        User user = null;

        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            User dbUser = userDao.getByEmail(email);
            if (dbUser.getPasswordHash().equals(passwordDigest.getDigestPassword(password)) && !dbUser.isDeleted()) {
                user = dbUser;
            }
        } catch (DaoException e) {
            throw new ServiceException("Unable get User from DB.", e);
        }
        return user;
    }

    @Override
    public boolean signUp(String name, String surname, String email, String passportId, String password, String confirmPassword) throws ServiceException {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        PasswordDigest passwordDigest = UtilFactory.getInstance().getPasswordDigest();

        User user = new User(0, name, surname, passwordDigest.getDigestPassword(password), email, passportId, false, UserRole.USER);

        try {
            if (isUserDataValid(password, confirmPassword, user)) {
                return userDao.createUser(user) == 1;
            } else {
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException("Exception while saving new user to DB.", e);
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
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.getUserById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User getByEmail(String email) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.getByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int restoreById(int id) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.restoreById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.getAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllUsers() throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.countAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int editPersonalData(int id, String name, String surname, String email, String passportId, String password) throws ServiceException {
        try {
            //TODO Valid
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            User user = userDao.getUserById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setPassportId(passportId);
            user.setPasswordHash(password);

            return userDao.updateUser(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsersByRoleId(int roleId) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.getUsersByRoleId(roleId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsersByStatus(String status) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.getUsersByStatus(status);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countByUserRole(UserRole userRole) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.countByUserRole(userRole);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
