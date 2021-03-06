package bankTransfer;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-02 15:12
 **/
public class UnsynchBankTest {
    public static void main(String[] args) {
        int nAccounts = 100;
        double initial_balance = 1000;
        double max_amount = 1000;
        int delay = 10;
        Bank bank = new Bank(nAccounts, initial_balance);
        for (int i = 0; i < nAccounts; i++) {
            int from = i;
            Runnable r = () -> {
                while (true) {
                    int to = (int) (bank.size() * Math.random());
                    double amount = max_amount * Math.random();
                    bank.transfer(from, to, amount);
                    try {
                        Thread.sleep((int) (delay * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
