import org.sibadi.Manufacturer;
import org.sibadi.Receipt;
import org.sibadi.discount.Discount;
import org.sibadi.discount.DiscountCard;
import org.sibadi.product.Fruit;
import org.sibadi.product.Meat;
import org.sibadi.product.Milk;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.math.BigDecimal;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        Discount.setMoney(new BigDecimal(3000)); // Задаём сумму для получения статуса постоянного покупателя

        Discount.add(Milk.class, new BigDecimal(0.5)); // Создаём скидку в 50% для Молока
        Discount.add(Meat.class, new BigDecimal(0.5)); // Создаём скидку в 50% для Мяса
        Discount.add(Fruit.class, new BigDecimal(0.5)); // Создаём скидку в 50% для Фруктов

        System.out.println(Discount.getInstance().toString()); // Показываем информацию о скидках

        var meat = new Meat("Мясо", "Вкусное", new BigDecimal(1000), Manufacturer.Ru); // Создаём экземпляр Мяса
        var milk = new Milk("Молоко", "Вкусное", new BigDecimal(1000), Manufacturer.En); // Создаём экземпляр Молока
        var fruit = new Fruit("Фрукт", "Вкусный", new BigDecimal(1000), Manufacturer.En); // Создаём экземпляр Фрукта

        //System.out.println(meat.toString()); // Показываем информации о Мясе
        //System.out.println(milk.toString()); // Показываем информации о Молоке
        //System.out.println(fruit.toString() + "\n"); // Показываем информации о Фрукте

        var path = "Save.txt";
        Save(meat,path);
        System.out.println(Load(path));

        var pathM = "SaveM.txt";
        Save(milk,pathM);
        System.out.println(LoadM(pathM));

        var pathF = "SaveF.txt";
        Save(fruit,pathF);
        System.out.println(LoadF(pathF)+ "\n");

        var discountCard = new DiscountCard("123", "Борис", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2005")); // Создаём карту

        //System.out.println(discountCard.toString() + "\n"); // Показываем информацию о Карте

        var pathD = "SaveD.txt";
        Save(discountCard,pathD);
        System.out.println(LoadD(pathD)+ "\n");

        var receipt = new Receipt(); // Создаём чек
        receipt.add(LoadF(pathF)); // Включаем в чек Фрукт
        receipt.add(Load(path)); // Включаем в чек Мясо
        receipt.add(LoadM(pathM)); // Включаем в чек Молоко

        System.out.println(receipt.toString()); // Выводим информацию о чеке

        System.out.println(discountCard.getDiscount(receipt)); // Показываем стоимость покупки без скидки

        //System.out.println(discountCard.toString() + "\n"); // Показываем информацию о Карте

        System.out.println(discountCard.getDiscount(receipt)); // Показываем стоимость покупки уже со скидкой


    }


    public static void Save(Meat meat, String nameFile) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(nameFile, "UTF-8");
        writer.println(meat.getName());
        writer.println(meat.getDescription());
        writer.println(meat.getPrice().toString());
        writer.println(meat.getManufacturer().toString());
        writer.close();
    }
    public static Meat Load(String nameFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("save.txt"));
        return new Meat( br.readLine(), br.readLine(), new BigDecimal(br.readLine()), Manufacturer.valueOf(br.readLine()));
    }

    public static void Save(Milk milk, String nameFile) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(nameFile, "UTF-8");
        writer.println(milk.getName());
        writer.println(milk.getDescription());
        writer.println(milk.getPrice().toString());
        writer.println(milk.getManufacturer().toString());
        writer.close();
    }
    public static Milk LoadM(String nameFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("saveM.txt"));
        return new Milk( br.readLine(), br.readLine(), new BigDecimal(br.readLine()), Manufacturer.valueOf(br.readLine()));
    }

    public static void Save(Fruit fruit, String nameFile) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(nameFile, "UTF-8");
        writer.println(fruit.getName());
        writer.println(fruit.getDescription());
        writer.println(fruit.getPrice().toString());
        writer.println(fruit.getManufacturer().toString());
        writer.close();
    }
    public static Fruit LoadF(String nameFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("saveF.txt"));
        return new Fruit( br.readLine(), br.readLine(), new BigDecimal(br.readLine()), Manufacturer.valueOf(br.readLine()));
    }

    public static void Save(DiscountCard discountCard, String nameFile) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(nameFile, "UTF-8");
        writer.println(discountCard.getPhone());
        writer.println(discountCard.getProprietor());
        writer.println(discountCard.getBirth());
        writer.close();
    }
    public static DiscountCard LoadD(String nameFile) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader("saveD.txt"));
        return new DiscountCard( br.readLine(), br.readLine(), new Date());
    }
}