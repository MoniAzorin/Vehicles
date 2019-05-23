package vehicles;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Car extends Vehicle {

    private List<Wheel> FrontWheels;
    private List<Wheel> BackWheels;

    public List<Wheel> getFrontWheels() {
        return FrontWheels;
    }

    public void setFrontWheels(List<Wheel> FrontWheels) {
        this.FrontWheels = FrontWheels;
    }

    public List<Wheel> getBackWheels() {
        return BackWheels;
    }

    public void setBackWheels(List<Wheel> BackWheels) {
        this.BackWheels = BackWheels;
    }

    public Car(String plate, String brand, String color) {
        super(plate, brand, color);
        this.FrontWheels = new ArrayList<>();
        this.BackWheels = new ArrayList<>();
    }

    public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
        addTwoWheels(frontWheels);
        addTwoWheels(backWheels);
    }

    public void addTwoWheels(List<Wheel> wheels) throws Exception {
        if (wheels.size() != 2) {
            throw new Exception("El numero de ruedas no es igual a 2");
        }

        Wheel rightWheel = wheels.get(0);
        Wheel leftWheel = wheels.get(1);

        if (!rightWheel.equals(leftWheel)) {
            throw new Exception("Las dos ruedas no són iguales");
        }

        this.wheels.add(leftWheel);
        this.wheels.add(rightWheel);
    }

    public Car Wheels(Scanner sc, Car car) {

        List<Wheel> twoWheels = new ArrayList<>();
        do{
            
            System.out.println("Introduce el diametro:  ");
            String diameter = sc.next();
            double wheeldiameter = Double.parseDouble(diameter);

            if (wheeldiameter >= 0.4 && wheeldiameter <= 4.0) {
                System.out.println("Introduce la marca:");
                String wheelBrand = sc.next().toLowerCase();

                Wheel wheel = new Wheel(wheelBrand, wheeldiameter);
                twoWheels.add(wheel);
                twoWheels.add(wheel);
                if (car.FrontWheels.isEmpty()==true) {
                    car.setFrontWheels(twoWheels);

                } else {
                    car.setBackWheels(twoWheels);
                }
   
                car.isWheelCorrect = true;
            } else {
                System.out.println("el diametro debe ser un numero en 0.4 y 4");
                car.isWheelCorrect = false;
            }
        }while(isWheelCorrect==false);

        return car;

    }

 
}
