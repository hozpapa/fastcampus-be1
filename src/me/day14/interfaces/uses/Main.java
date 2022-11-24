package me.day14.interfaces.uses;

public class Main {
    public static void main(String[] args) {
//        DriveLicenseAble highStudent = new HighStudent();
        DriveLicenseAble univStudent = new UnivStudent();
        univStudent.renew();
        univStudent.defaultMethod();
        UnivStudent.staticMethod();
        DriveLicenseAble.staticMethod();
        System.out.println();

        DriveLicenseAble worker = new Worker();
        worker.renew();
        worker.defaultMethod();
        DriveLicenseAble.staticMethod();
        System.out.println();

        a(new UnivStudent()); // DriveLicenseAble driveLicenseAble = new UnivStudent()
        a(new Worker()); // DriveLicenseAble driveLicenseAble = new Worker()
//        a(new HighStudent()); // DriveLicenseAble driveLicenseAble = new HighStudent() (X)

        ////////////////////////////////////////////////////////////////////
        AmusementParkSaleAble highStudent = new HighStudent();
        AmusementParkSaleAble univStudent1 = new UnivStudent();
//        SaleAble worker1 = new Worker();
        highStudent.saleRate();
        univStudent1.saleRate();

        b(new HighStudent());
        b(new UnivStudent());
//        b(new Worker());
        System.out.println();

        System.out.println("최종 놀이공원 금액 => " + price(new Baby()));
        System.out.println("최종 놀이공원 금액 => " + price(new HighStudent()));
        System.out.println("최종 놀이공원 금액 => " + price(new UnivStudent()));
        System.out.println("최종 놀이공원 금액 => " + price(new Worker()));
    }
    public static void a(DriveLicenseAble driveLicenseAble) {
        System.out.println("a method()");
    }
    public static void b(AmusementParkSaleAble saleAble) {
        System.out.println("b method()");
    }
    public static double price(Person person) { // Baby, HighStudent, UnivStudent, Worker => Person
        ///////////////////////////////////
        // BabySaleAble extends AmusementParkSaleAble
        // - Baby
        // - Baby => BabySaleAble => AmusementParkSaleAble
        // StudentSaleAble extends AmusementParkSaleAble
        // - HighStudent, UnivStudent
        // - HighStudent, UnivStudent => StudentSaleAble => AmusementParkSaleAble
        // Other
        // - Worker
        //////////////////////////////////


        double price = 30000;
        // Baby implement BabySaleAble => AmusementParkSaleAble amusementParkSaleAble = new Baby();
        // HighStudent implement StudentSaleAble => AmusementParkSaleAble amusementParkSaleAble = new HighStudent();
        // UnivStudent implement StudentSaleAble => AmusementParkSaleAble amusementParkSaleAble = new UnivStudent();
        if (person instanceof AmusementParkSaleAble) { // AmusementParkSaleAble => StudentSaleAble, BabySaleAble
            return price * (1 - ((AmusementParkSaleAble) person).saleRate());
        } else {
            return price;
        }
    }
}
