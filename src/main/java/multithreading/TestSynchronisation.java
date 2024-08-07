package multithreading;

public class TestSynchronisation {
    public static void main(String[] args) {
        Table t = new Table();
        Thread t1 = new Thread(){
            public void run(){
                t.printTable(5);
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                t.printTable(100);
            }
        };
        t1.start();
        t2.start();
    }
}

class Table{
    int test = 0;
    synchronized void printTable(int n){
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i + "\t..." + test);
            test++;
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
