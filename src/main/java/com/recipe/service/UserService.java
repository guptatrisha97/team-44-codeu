package com.recipe.service;

import com.recipe.dao.DaoFactory;
import com.recipe.dao.UserDao;
import com.recipe.dao.UserDaoImpl;
import com.recipe.domain.User;

public class UserService {

    UserDao userDao= DaoFactory.getUserDao();

    public void regist(User user) throws UserException
    {
        User _user=userDao.findByUsername(user.getUsername());
        if (_user!=null)
        {
            throw  new UserException("User name"+user.getUsername()+"has been registered!");
        }
        userDao.add(user);
    }

    public User login(User user) throws UserException
    {
        User _user=userDao.findByUsername(user.getUsername());
        if (_user==null)
        {
            throw new UserException("User name does not exist!");
        }
        if (!user.getPassword().equals(_user.getPassword()))
        {
            throw new UserException("Wrong password!");
        }
        return _user;
    }
}
