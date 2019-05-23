package vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bike extends Vehicle {

        Wheel FrontWheel;
        Wheel BackWheel;
        
	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

    public Wheel getFrontWheel() {
        return FrontWheel;
    }

    public void setFrontWheel(Wheel FrontWheel) {
        this.FrontWheel = FrontWheel;
    }

    public Wheel getBackWheel() {
        return BackWheel;
    }

    public void setBackWheel(Wheel BackWheel) {
        this.BackWheel = BackWheel;
    }
        
        
    public void addWheels(Wheel FrontWheel, Wheel BackWheel) throws Exception {

        this.wheels.add(FrontWheel);
        this.wheels.add(BackWheel);
    }

    public Bike InfoWheels(Scanner sc, Bike bike) {
        
        System.out.println("el diametro");
        Double wheeldiameter = sc.nextDouble();
        if (wheeldiameter >= 0.4 && wheeldiameter<=4) {
             System.out.println("la marca");
             String wheelBrand = sc.next().toLowerCase();
            
            if(bike.getFrontWheel()==null){
               bike.setFrontWheel(new Wheel(wheelBrand, wheeldiameter)); 
            }else{
                bike.setBackWheel(new Wheel(wheelBrand, wheeldiameter));
            }
               
            bike.isWheelCorrect=true;
        }else{
            System.out.println("el diametro debe ser un numero en 0.4 y 4");
            bike.isWheelCorrect=false;
        }
        
        return bike;
        
        
    }
        
        

}
