package org.sibadi.discount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Discount {

    private final static Map<Class, BigDecimal> discounts = new HashMap<Class, BigDecimal>();
    private final static Discount instance = new Discount();
    private static BigDecimal money = new BigDecimal(0);

    private Discount() {
    }

    public static void setMoney(BigDecimal money){
        Discount.money = money;
    }

    public static BigDecimal getMoney() {
        return money;
    }

    public static Discount getInstance(){
        return instance;
    }

    public final static Map<Class, BigDecimal> getDiscounts() {
        return discounts;
    }

    public final static <T extends Class, Product> void add(T product, BigDecimal discount) { //***********
        discounts.put(product, discount);
    }

    public final static <T extends Class, Product> void remove(T product) { //************
        discounts.remove(product);
    }

    @Override
    public String toString() {//*********************
        String outSting = new String();
        for (Class discount : discounts.keySet())
            outSting += discount.getName() + " " + discounts.get(discount) + "\n";
        outSting += money + "\n";
        return outSting;
    }
}