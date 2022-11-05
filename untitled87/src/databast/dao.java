package databast;

import java.sql.SQLException;

public interface dao {
    void addStudent() throws Exception;
    void delStudent()throws ClassNotFoundException,SQLException;
    void showAll()throws  ClassNotFoundException,SQLException;
    void quary()throws ClassNotFoundException,SQLException;//查询
    void modify()throws ClassNotFoundException,SQLException;//修改
}
