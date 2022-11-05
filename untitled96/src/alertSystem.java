import java.sql.SQLException;
import java.util.ArrayList;

public class alertSystem extends Thread{
    ShowTemperature showTemperature=new ShowTemperature();
    public boolean warn(ArrayList<Double>results)
    {
        int errorCount=0;
        if(results!=null)
        {
            for (Double res :
                    results) {
                if (res < 18 || res > 22)
                {
                    errorCount++;
                }
            }
        }
        else {
            System.out.println("预警系统缺乏数据，请稍等");
            return false;
        }
        if (errorCount==results.size())
        {
            System.out.println("阈值18~22长达一分钟");
        }
        return true;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                this.warn(showTemperature.getTemperatureByTime(6));
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
