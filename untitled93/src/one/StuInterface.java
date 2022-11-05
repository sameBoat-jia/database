package one;

import java.util.ArrayList;

public interface StuInterface {
    double getAverage(ArrayList<Grade>grades);

    static double getMax(ArrayList<Grade> grades) {
        return 0;
    }

    static double getMin(ArrayList<Grade> grades) {
        return 0;
    }

    ArrayList<Grade>getList(ArrayList<Grade>grades,int level);
    void getAll(ArrayList<Grade>grades);
}
