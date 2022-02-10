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

/**
 * UserServiceImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    private static final int SUCCESSFUL_OPERATION = 1;
    private static final int DEFAULT_USER_ID = 0;
    private static final boolean DEFAULT_IS_USER_DELETED = false;
    private static final boolean UNSUCCESSFUL_OPERATION = false;

    private final UserDao userDao = DaoFactory.getInstance().getUserDao();

    /**
     * {@inheritDoc}
     */
    @Override
    public User login(String email, String password) throws ServiceException {
        PasswordDigest passwordDigest = UtilFactory.getInstance().getPasswordDigest();
        User user = null;

        try {
            User dbUser = userDao.getByEmail(email);
            if (dbUser != null && dbUser.getPasswordHash().equals(passwordDigest.getDigestPassword(password)) && !dbUser.isDeleted()) {
                user = dbUser;
            }
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean signUp(String name, String surname, String email, String passportId, String password, String confirmPassword) throws ServiceException {
        PasswordDigest passwordDigest = UtilFactory.getInstance().getPasswordDigest();

        User user = new User(DEFAULT_USER_ID, name, surname, passwordDigest.getDigestPassword(password), email, passportId, DEFAULT_IS_USER_DELETED, UserRole.USER_WITHOUT_APPLICATION);

        try {
            if (isUserDataValid(password, confirmPassword, user)) {
                return userDao.createUser(user) == SUCCESSFUL_OPERATION;
            } else {
                return false;
            }
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    private boolean isUserDataValid(String password, String confirmPassword, User user) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        return validatorFactory.getPasswordValidator().validate(password)
                && password.equals(confirmPassword) && validatorFactory.getUserValidator().validate(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getById(int id) throws ServiceException {
        try {
            return userDao.getUserById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getByEmail(String email) throws ServiceException {
        try {
            return userDao.getByEmail(email);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) throws ServiceException {
        try {
            return userDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int restoreById(int id) throws ServiceException {
        try {
            return userDao.restoreById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDao.getAllUsers();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllUsers() throws ServiceException {
        try {
            return userDao.countAllUsers();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllApplicants() throws ServiceException {
        try {
            return userDao.getAllApplicants();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllAdministrators() throws ServiceException {
        try {
            return userDao.getAllAdministrators();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean editPersonalData(int id, String name, String surname, String email, String passportId) throws ServiceException {
        Validator<User> userValidator = ValidatorFactory.getInstance().getUserValidator();

        try {
            User user = userDao.getUserById(id);
            if (!user.getEmail().equals(email) && userDao.getByEmail(email) != null) {
                return UNSUCCESSFUL_OPERATION;
            } else {
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setPassportId(passportId);

                if (userValidator.validate(user)) {
                    return userDao.updateUser(user) == SUCCESSFUL_OPERATION;
                } else {
                    return UNSUCCESSFUL_OPERATION;
                }
            }
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean changeUserRole(int id, UserRole userRole) throws ServiceException {
        try {
            User user = userDao.getUserById(id);
            user.setUserRole(userRole);

            return userDao.updateUser(user) == SUCCESSFUL_OPERATION;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUsersByRoleId(int roleId) throws ServiceException {
        try {
            return userDao.getUsersByRoleId(roleId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUsersByStatus(String status) throws ServiceException {
        try {
            return userDao.getUsersByStatus(status);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countByUserRole(UserRole userRole) throws ServiceException {
        try {
            return userDao.countByUserRole(userRole);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
