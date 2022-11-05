package database;

import java.sql.SQLException;

public interface dao {
    void addStudent() throws ClassNotFoundException, SQLException;

    void delStudent() throws ClassNotFoundException, SQLException;

    void showAll() throws ClassNotFoundException, SQLException;

    void quary() throws ClassNotFoundException, SQLException;

    void modify() throws ClassNotFoundException, SQLException;

}
