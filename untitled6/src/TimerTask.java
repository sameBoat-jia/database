import java.util.TimerTask;

class MyTimerTask extends TimerTask {
    String jdbc_driver;
    String url;
    String user;
    String pass;

    public MyTimerTask(String jdc_driver, String url, String user, String pass) {
        this.jdbc_driver = jdbc_driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public void run() {
        try {
            new DbUnit().add(this.jdbc_driver, this.url, this.user, this.pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyTimerTask1 extends TimerTask {
    public void run() {
        new DbUnit().query();
    }
}

