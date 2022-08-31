package org.example;

import java.util.Scanner;

public class Menu {

    public static Converter converter = new Converter();
    public void mainMenu() throws Exception {
        try {
            String line = "===============================";
            System.out.println("TEST CASE JAVA INFOSYS");
            System.out.println("1. Menentukan Point Dengan Jumlah terbesar!");
            System.out.println("2. Menghitung sisa poin setelah di redeem dgn point terbesar jika poin yg dimiliki adalah 1000p / user input!");
            System.out.println("3. Redeem all point prioritas point terbesar!");
            System.out.println("0. Exit");
            Scanner input = new Scanner(System.in);
            System.out.println("Please input your choice here! :");
            if (!input.hasNextInt()) {
                System.out.println("Please input your number");
                this.Enter();
                this.mainMenu();
            }
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    int point = this.point();
                    Converter voucher = converter.convert(point);
                    System.out.println(line);
                    System.out.println(" 1 : " + voucher.getMessage());
                    System.out.println(line);
                    this.Enter();
                }
                case 2 -> {
                    int point = this.point();
                    Converter test2 = converter.convert(point);
                    Converter test2case = converter.convert(1000);
                    System.out.println(line);
                    System.out.println(" 2 : " + "Your remaining points : " + test2.getsisaPoint());
                    System.out.println(" 2 : If your point = 1000, " + " Your remaining points : " + test2case.getsisaPoint());
                    System.out.println(line);
                    this.Enter();
                }
                case 3 -> {
                    int point = this.point();
                    Converter voucherTest3 = Test3(point);
                    System.out.println(line);
                    System.out.println(voucherTest3.getMessage());
                    System.out.println(line);
                    this.Enter();
                }
                case 0 -> {
                    System.out.println(line);
                    System.out.println("DONE!");
                    System.out.println(line);
                    System.exit(0);
                }

            }
            this.mainMenu();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public void Enter(){
        System.out.println("Press \"ENTER\" ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static Converter Test3(Integer inputPoint) {
        int remainingPoint = inputPoint;
        int voucher100 = 0, voucher50 = 0, voucher25 = 0, voucher10 = 0;
        while (remainingPoint > 100) {
            Converter voucherRemainingPoints = converter.convert(converter.getsisaPoint());
            switch (voucherRemainingPoints.getRedeemVoucher()) {
                case "100000" -> voucher100 = 1;
                case "50000" -> voucher50 = 1;
                case "25000" -> voucher25 = 1;
                case "10000" -> voucher10 = 1;
            }
            remainingPoint = voucherRemainingPoints.getsisaPoint();
        }
        String message;
        if (remainingPoint != inputPoint) {
            message = ("Test 3 : Your point : " + inputPoint + "p , " +
                    "you can redeem "
                    + voucher100 + " voucher 100.000, "
                    + voucher50 + " voucher 50.000, "
                    + voucher25 + " voucher 25000, "
                    + voucher10 + " voucher 10000, "
                    + "remaining point : " + remainingPoint);
        }
        return new Converter(remainingPoint, message, null);
    }
    public int point() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your  points here :");
        if (!input.hasNextInt()) {
            System.out.println("Please input your number");
            this.Enter();
            this.mainMenu();
        }
        int inputPoint = input.nextInt();
        if (inputPoint <= 0) {
            System.out.println("Your input must > 0");
            this.Enter();
            this.mainMenu();
        }
        return inputPoint;
    }

}