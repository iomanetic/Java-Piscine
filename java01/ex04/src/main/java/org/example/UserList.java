package org.example;

public interface UserList {

    public void addUser(User user);

    public User getUserWithId(Integer id) throws UserNotFoundException;

    public User getUserWithIndex(Integer index);

    public Integer getNumOfUsers();
}
