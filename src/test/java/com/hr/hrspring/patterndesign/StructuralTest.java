package com.hr.hrspring.patterndesign;

import com.hr.hrspring.patterDesign.Structural.adapter.Adapter;
import com.hr.hrspring.patterDesign.Structural.adapter.DataBaseData;
import com.hr.hrspring.patterDesign.Structural.adapter.DisplayData;
import com.hr.hrspring.patterDesign.Structural.bridge.composite.bridge.Facebook;
import com.hr.hrspring.patterDesign.Structural.bridge.composite.bridge.Instagram;
import com.hr.hrspring.patterDesign.Structural.bridge.composite.impl.Android;
import com.hr.hrspring.patterDesign.Structural.bridge.composite.impl.IOS;
import com.hr.hrspring.patterDesign.Structural.bridge.inherence.bridge.AmericanRestaurant;
import com.hr.hrspring.patterDesign.Structural.bridge.inherence.bridge.ItalianRestaurant;
import com.hr.hrspring.patterDesign.Structural.bridge.inherence.impl.HawaianaPizza;
import com.hr.hrspring.patterDesign.Structural.bridge.inherence.impl.PepperonPizza;
import com.hr.hrspring.patterDesign.Structural.composite.baeldung.base.Department;
import com.hr.hrspring.patterDesign.Structural.composite.baeldung.composite.HeadDepartment;
import com.hr.hrspring.patterDesign.Structural.composite.baeldung.leafs.FinancialDepartment;
import com.hr.hrspring.patterDesign.Structural.composite.baeldung.leafs.SalesDepartment;
import com.hr.hrspring.patterDesign.Structural.composite.basic.Composite;
import com.hr.hrspring.patterDesign.Structural.composite.basic.Equipment;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.ChristmasTreeImpl;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.concrete.BubbleLights;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.concrete.Garland;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.interf.ChristmasTree;
import com.hr.hrspring.patterDesign.Structural.decorator.basic.component.Notifier;
import com.hr.hrspring.patterDesign.Structural.decorator.basic.concrete.FacebookDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.basic.concrete.WhatsAppDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.basic.interf.INotifier;
import com.hr.hrspring.patterDesign.Structural.facade.baeldung.CarEngineFacade;
import com.hr.hrspring.patterDesign.Structural.facade.basic.BuyCryptoFacade;
import com.hr.hrspring.patterDesign.Structural.flyweight.baeldung.Color;
import com.hr.hrspring.patterDesign.Structural.flyweight.baeldung.VehicleFactory;
import com.hr.hrspring.patterDesign.Structural.flyweight.basic.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StructuralTest {

    @Test
    void adapterTest(){
        Adapter newAdapter = new Adapter();
        List<DataBaseData> dataBaseData = List.of(new DataBaseData(10, 10L),
                new DataBaseData(11, 11L),
                new DataBaseData(12, 12L),
                new DataBaseData(13, 13L),
                new DataBaseData(14, 14L));
        List<DisplayData>  displayData = newAdapter.convertData(dataBaseData);

        Assertions.assertEquals(4, displayData.size() - 1);
        Assertions.assertEquals(String.class, displayData.get(4).data.getClass());
        Assertions.assertEquals(Long.class, displayData.get(4).number.getClass());
    }

    @Test
    void bridgeCompositeTest(){

        Facebook facebook = new Facebook(new Android());
        Instagram instagram = new Instagram(new IOS());
        facebook.runApplication();
        instagram.runApplication();

    }

    @Test
    void bridgeInheritanceTest() {

        AmericanRestaurant americanRestaurant = new AmericanRestaurant(new PepperonPizza());
        americanRestaurant.deliver();
        System.out.println();
        ItalianRestaurant italianRestaurant = new ItalianRestaurant(new HawaianaPizza());
        italianRestaurant.deliver();

    }

    @Test
    void compositeBasicTest(){

        Composite computer = new Composite("PC");
        Equipment processor = new Equipment("Processor", 1000);
        Equipment hdd = new Equipment("Hard Drive", 250);

        Composite memory = new Composite("Memory");
        Equipment ram = new Equipment("Random Access Memory", 75);
        Equipment rom = new Equipment("Read Only Memory", 100);

        memory.add(rom).add(ram);
        computer.add(processor).add(hdd).add(memory);

        System.out.println("Computer price " + computer.getPrice());
        System.out.println("Memory price " + memory.getPrice());
    }

    @Test
    void compositeBaeldungTest() {

        Department salesDepartment = new SalesDepartment(1, "Sales Department");
        Department finalcialDepartment = new FinancialDepartment(1, "Financial Department");

        HeadDepartment headDepartment = new HeadDepartment(3, "Head Department");

        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(finalcialDepartment);

        headDepartment.printDepartmentName();

    }

    @Test
    void decoratorBasicTest() {
        INotifier notifier = new FacebookDecorator(
                new WhatsAppDecorator(new Notifier("create Notifiers of ")));

        notifier.send(" << This Message >> ");

    }

    @Test
    void decoratorBaeldungTest() {
        ChristmasTree treeOne = new Garland(new ChristmasTreeImpl());
        Assertions.assertEquals(treeOne.decorate(), "Christmas tree with Garland");

        ChristmasTree treeTwo = new BubbleLights(
                new Garland(new Garland(new ChristmasTreeImpl())));
        Assertions.assertEquals(treeTwo.decorate(),
                "Christmas tree with Garland with Garland with Bubble Lights");
    }

    @Test
    void facadeBasicTest() {
        BuyCryptoFacade facade = new BuyCryptoFacade();
        facade.buyCryptoCurrency(100, "BTC");
    }

    @Test
    void facadeBaeldungTest() {
        CarEngineFacade facade = new CarEngineFacade();
        System.out.println("Car start >> ");
        facade.startEngine();
        System.out.println("Car stop >> ");
        facade.stopEngine();
    }


    static final int BOOK_TYPES = 2;
    static final int BOOK_TO_INSERT = 10_000_000;

    @Test
    void flyweightBasicTest() {

        Store store = new Store();
        int numberBooks = 0;
        for(int i = 0; i < BOOK_TO_INSERT / BOOK_TYPES; i++){
            store.storeBook(Store.getRandomName(), Store.getRandomPrice(), "Action", "Follett", "Stuff");
            store.storeBook(Store.getRandomName(), Store.getRandomPrice(), "Fantasy", "Ingram", "Extra");
            numberBooks++;
        }

        System.out.println(numberBooks + " Books Inserted");
        System.out.println("-------------------------");
        System.out.println("Memory Usage:");
        System.out.println("Book Size (20 Bytes) * " + BOOK_TO_INSERT
        + " + Bookstypes Size (30 Bytes) * " + BOOK_TYPES);
        System.out.println("-------------------------");
        System.out.println("Total: " + ((BOOK_TO_INSERT * 20 + BOOK_TYPES * 30) / 1024 / 1024)
            +"MB (instead of " + ((BOOK_TO_INSERT * 50) /1024 / 1024) + "MB)");
        System.out.println(store);
    }
    @Test
    void flyweightBaeldungTest() {

        com.hr.hrspring.patterDesign.Structural.flyweight.baeldung.Vehicle car = VehicleFactory.create(Color.PURPLE);
        Assertions.assertEquals(Color.PURPLE, car.getColor());

        car = VehicleFactory.create(Color.BLUE);
        Assertions.assertEquals(Color.BLUE, car.getColor());

    }





}
