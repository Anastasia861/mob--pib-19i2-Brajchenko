import org.sibadi.Manufacturer;
import org.sibadi.Receipt;
import org.sibadi.discount.Discount;
import org.sibadi.discount.DiscountCard;
import org.sibadi.product.Fruit;
import org.sibadi.product.Meat;
import org.sibadi.product.Milk;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {

        Discount.setMoney(new BigDecimal(3000)); // Задаём сумму для получения статуса постоянного покупателя

        Discount.add(Milk.class, new BigDecimal(0.5)); // Создаём скидку в 50% для Молока
        Discount.add(Meat.class, new BigDecimal(0.5)); // Создаём скидку в 50% для Мяса
        Discount.add(Fruit.class, new BigDecimal(0.5)); // Создаём скидку в 50% для Фруктов

        System.out.println(Discount.getInstance().toString()); // Показываем информацию о скидках

        var meat = new Meat("Мясо", "Вкусное", new BigDecimal(1000), Manufacturer.Ru); // Создаём экземпляр Мяса
        var milk = new Milk("Молоко", "Вкусное", new BigDecimal(1000), Manufacturer.En); // Создаём экземпляр Молока
        var fruit = new Fruit("Фрукт", "Вкусный", new BigDecimal(1000), Manufacturer.En); // Создаём экземпляр Фрукта

        System.out.println(meat.toString()); // Показываем информации о Мясе
        System.out.println(milk.toString()); // Показываем информации о Молоке
        System.out.println(fruit.toString() + "\n"); // Показываем информации о Фрукте

        var discountCard = new DiscountCard("123", "Борис", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2005")); // Создаём карту

        System.out.println(discountCard.toString() + "\n"); // Показываем информацию о Карте

        var receipt = new Receipt(); // Создаём чек
        receipt.add(fruit); // Включаем в чек Фрукт
        receipt.add(meat); // Включаем в чек Мясо
        receipt.add(milk); // Включаем в чек Молоко

        System.out.println(receipt.toString()); // Выводим информацию о чеке

        System.out.println(discountCard.getDiscount(receipt)); // Показываем стоимость покупки без скидки

        System.out.println(discountCard.toString() + "\n"); // Показываем информацию о Карте

        System.out.println(discountCard.getDiscount(receipt)); // Показываем стоимость покупки уже со скидкой
    }
}