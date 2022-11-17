import Transport.Car;

import java.time.LocalDate;

import static Transport.Car.getInsurance;

public class Main {
    public static void main(String[] args) {
        Human maxim = new Human("Максим", "Минск",1988,
                "бренд-менеджер");

        System.out.println(maxim);

        Human anya = new Human("Аня","Москва",1993,
                "методист образовательных программ");

        System.out.println(anya);

        Human katya = new Human("Катя","Калининград",1992,
                "продакт-менеджер");

        System.out.println(katya);

        Human artyom = new Human("Артём","Москва",1995,
                "директор по развитию бизнеса");

        System.out.println(artyom);

        Human vlad = new Human("Владимир","Казань",2001,"Безработный");
        System.out.println(vlad);

        System.out.println();


        Flower rosa = new Flower("Роза обыкновенная","Голандия",35.59f,-1);
        System.out.println(rosa);

        Flower hrizantema = new Flower("Хризантема","",15.00f,5);
        System.out.println(hrizantema);

        Flower pion = new Flower("Пион","Англия",69.90f,1);
        System.out.println(pion);

        Flower gipsofila = new Flower("Гипсофила","Турция",19.50f,10);
        System.out.println(gipsofila);
        System.out.println();

        Buqet buqet = new Buqet(rosa, rosa,rosa,gipsofila,gipsofila);
        System.out.println("Стоимость букета: " +buqet.getCost()+ " руб.");
        System.out.println("Букет простоит: " +buqet.getLifeSpan()+ " суток");
        System.out.println();

        Car lada = new Car("Lada","Granta",1.7f,
                "желтый",2015,"Россия", "механика", "Седан",
                "Х256МВ123", 5, true,
                new Car.Key(false, false),
                new Car.Insurance(
                        LocalDate.now().plusMonths(2),
                        6000.0f,
                        "321654987"));
        if (!Car.getInsurance().isInsuranceValid()){
            System.out.println("Страховка просрочена");
        }

        System.out.println(lada);

        Car audi = new Car("Audi","A8 50 L TDI quattro",3.0f,
                "Черный",2020,"Германия", "Валидатор",
                "Седан", "О123МХ189", 5, true,
                new Car.Key(true, true),
                new Car.Insurance(
                        LocalDate.now().plusMonths(5),
                        8000.0f,
                        "123456789"));
        if (!getInsurance().isInsuranceValid()){
            System.out.println("Страховка просрочена");
        }

        System.out.println(audi);

        Car bmw = new Car("BMW","Z8",3.0f,
                "Черный",2021,"Германия",
                "Автомат", "Кабриолет", "М666ММ777", 2, false,
                new Car.Key(true, true),
                new Car.Insurance(
                        LocalDate.now().plusMonths(6),
                        10000.0f,
                        "159357456"));
        if (!getInsurance().isInsuranceValid()){
            System.out.println("Страховка не действительна");
        }

        System.out.println(bmw);

        Car kia = new Car("KIA","Sportage 4-го поколения",2.4f,
                "Красный",2018,"Южная Корея",
                "Вариатор", "Универсал", "Н351ОХ161", 5, true,
                new Car.Key(true, true),
                new Car.Insurance(
                        LocalDate.now().plusMonths(11),
                        10000.00f,
                        "321951753"));
        if (!getInsurance().isInsuranceValid()){
            System.out.println("Страховка не действительна");
        }

        System.out.println(kia);

        Car hyundai = new Car("Hyundai","Avante",1.6f,
                "Оранжевый",2016,"Южная Корея",
                "Автомат", "Седан", "К687ОТ199", 5, true,
                new Car.Key(true, true),
                new Car.Insurance(
                        LocalDate.now().plusMonths(0),
                        7000.00f,
                        "951357789"));
        if (!getInsurance().isInsuranceValid()){
            System.out.println("Страховка не действительна. Оформите новую.");
        }

        System.out.println(hyundai);

    }
}