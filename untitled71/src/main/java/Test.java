public class Test extends Thread{
    SendTemperature sendTemperature=new SendTemperature();
    ShowTemperature showTemperature=new ShowTemperature();

    public static void main(String[] args) throws Exception{
        Test test1=new Test();
        int time=0;
        while (true)
        {
            while (time%6!=5){
                test1.sendTemperature.insert();
                System.out.println("now Temperature"+test1.showTemperature.getTemperaturesByTime(1).get(0).toString());
                time++;
                System.out.println();
                Thread.sleep(10000);
            }
            time=0;
            time++;
            test1.sendTemperature.insert();
            test1.showTemperature.getAverageTemperatureBy60();
            System.out.println();
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        sendTemperature.start();
        showTemperature.start();
    }
}
