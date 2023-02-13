package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();

    }
}
