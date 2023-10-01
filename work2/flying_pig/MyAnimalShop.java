import exception.AnimalNotFountException;
import exception.InsufficientBalanceException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAnimalShop implements AnimalShop {
    double balance=100;
    double oldBalance=100;
    List<Animal> animalArrayList = new ArrayList<>();
    List<Customer> customerArrayList = new ArrayList<>();
    boolean openOrExit = true;

    @Override
    public void buyAnimal(Animal animal) {
        //如余额不足则抛出异常InsufficientBalanceException
        if ((balance - animal.price) < 0) {
            System.out.println(animal.price);
            throw new InsufficientBalanceException("钱不够了，买什么动物啊");
        } else {
            //买入一只动物，记得在动物列表中添加
            balance = balance - animal.price;
            animalArrayList.add(animal);
            System.out.println("还剩："+balance);
        }
    }

    @Override
    public void entertainingCustomer(Customer customer) {
        //接受客户参数，在顾客列表中加入新顾客
        customerArrayList.add(customer);
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("输入1选择购买动物，输入0退出");
            int type=scanner.nextInt();
            if(type==0){
                break;
            }
            //出售动物，如果店内没有动物，抛出AnimalNotFoundException
            if (animalArrayList.size() == 0) {
                throw new AnimalNotFountException("没动物了，滚吧，来买个屁");
            } else {
                //输入购买的动物
                System.out.println("输入购买的动物编号：");
                int number = scanner.nextInt();
                if (number < animalArrayList.size()) {
                    //通过toString输出动物信息
                    System.out.println(animalArrayList.get(number).toString());
                    //收钱啦,每只利润5块
                    balance = animalArrayList.get(number).price + balance+5;
                    //移除动物
                    animalArrayList.remove(number);
                    //更新顾客到店次数和到店最新时间
                    customer.setCount(customer.getCount() + 1);
                    customer.setArriveDay(LocalDate.now());
                } else {
                    System.out.println("输入越界");
                }
            }

        }
        scanner.close();
    }

    @Override
    public void exit() {
        for (Customer customer : customerArrayList) {
            if (LocalDate.now().equals(customer.getArriveDay())) {
                System.out.println(customerArrayList);
                System.out.println(balance-oldBalance);
                oldBalance=balance;
            }
        }
    }
}
