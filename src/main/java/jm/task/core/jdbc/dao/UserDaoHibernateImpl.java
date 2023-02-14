package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    Transaction transaction = null;
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS user"
                + "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "firstName VARCHAR(45) NOT NULL, lastName VARCHAR(45) NOT NULL,"
                + "age INT NOT NULL)";
        try (Session session = Util.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String sqlCommand = "DROP TABLE IF EXISTS user";
        try (Session session = Util.getFactory().openSession()){
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlCommand).addEntity(User.class).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);

        try (Session session = Util.getFactory().openSession() ) {
        transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> user;
        try (Session session = Util.getFactory().openSession()) {
            user = session.createQuery("from User user" , User.class ).list();
            for (User value : user) {
                System.out.println(value.toString());
            }
            return user;
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("TRUNCATE TABLE user ").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
