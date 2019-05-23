/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles;

import java.util.Scanner;

/**
 *
 * @author azorin
 */
public class AppVehicles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

// 1) Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
        Scanner sc = new Scanner(System.in);
        boolean islicenseNumber = false;
        String liscenseNumber;
        String vehicleType;
        boolean isBikeOrCar = true;

        do {
            try {
                System.out.println("Que quieres Crear?:\n"
                        + "-Car\n"
                        + "-Bike");
                vehicleType = sc.next().toLowerCase();

                //Mètode per comprovar que es un cotxe o una bici
                IsBikeOrCar(vehicleType);

                // Comprovar que la Matricula es correcta:    
                do {
                    System.out.println("introduce la matricula:");
                    liscenseNumber = sc.next();
                    islicenseNumber = LiscenseNumber(liscenseNumber);
                } while (islicenseNumber == false);

                System.out.println("introduce la marca");
                String brand = sc.next();
                System.out.println("introduce el color");
                String colour = sc.next();

                switch (vehicleType) {
                    case "car":
                        Car car = new Car(liscenseNumber, brand, colour);
                        boolean isCarCorrect = true;
                        do {
                            try {
                                // Demanar informació de les rodes
                                System.out.println("Introduce la información de las ruedas delanteras:");
                                car = car.Wheels(sc, car);

                                System.out.println("Introduce la información de las ruedas traseras:");
                                car = car.Wheels(sc, car);

                                car.addWheels(car.getFrontWheels(), car.getBackWheels());

                                System.out.println("Muy bien! Ya has creado el coche!");
                                isBikeOrCar=true;
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                                isCarCorrect = false;
                            }
                        } while (isCarCorrect == false);
                        break;
                    case "bike":
                        Bike bike = new Bike(liscenseNumber, brand, colour);
                        boolean isBikeCorrect = true;
                        do {
                            System.out.println("Introduce la información de las rueda delantera:");
                            do {
                                bike = bike.InfoWheels(sc, bike);
                            } while (bike.isWheelCorrect == false);
                            System.out.println("Introduce la información de las rueda trasera:");
                            do {
                                bike = bike.InfoWheels(sc, bike);
                            } while (bike.isWheelCorrect == false);

                            try {
                                bike.addWheels(bike.getFrontWheel(), bike.getBackWheel());
                                System.out.println("Muy bien! Ya has creado la bici!");
                                isBikeOrCar=true;                               
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                                isBikeCorrect = false;
                            }
                        } while (isBikeCorrect == false);
                        break;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                isBikeOrCar = false;

            }

        } while (isBikeOrCar == false);

    }

    private static boolean LiscenseNumber(String liscenseNumber) {
        char[] liscense = liscenseNumber.toCharArray();
        int contNum = 0;
        int contLetter = 0;
        for (char c : liscense) {
            if (Character.isDigit(c)) {
                contNum = contNum + 1;
            }
            if (Character.isLetter(c)) {
                contLetter = contLetter + 1;
            }
        }
        if (contNum == 4 && (contLetter == 2 || contLetter == 3)) {
            return true;
        } else {
            System.out.println("La matrícula debe contener 4 numeros y 2 o 3 letras");
            return false;
        }
    }

    private static void IsBikeOrCar(String vehicleType) throws Exception {
        if (vehicleType.equals("car") || vehicleType.equals("bike")) {

        } else {
            throw new Exception("Te has equivocado");
        }

    }

}
