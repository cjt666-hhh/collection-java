package animal;

import java.time.LocalDate;

public interface AnimalBuyable {
//这里就是按照任务定义的一个接口
    public abstract void buyCat(Cat c);

    public abstract void buyDog(Dog d);

    public abstract void treatCustomer(Customer c );


    public abstract void offDuty(LocalDate localDate);








}
