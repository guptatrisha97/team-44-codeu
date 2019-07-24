package com.recipe.dao;

import com.recipe.domain.User;

public interface UserDao
{
    public User findByUsername(String username);
    public void add(User user);
}
