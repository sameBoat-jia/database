package dataBase_test;

import java.sql.SQLException;

public interface dao {
    public void addStudent() throws ClassNotFoundException, SQLException;

    public void delStudent() throws ClassNotFoundException, SQLException;

    public void showAll() throws ClassNotFoundException, SQLException;

    public void quary() throws ClassNotFoundException, SQLException;

    public void modify() throws ClassNotFoundException, SQLException;

}
