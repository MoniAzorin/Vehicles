package vehicles;

import java.util.Objects;

public class Wheel {
    
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.setBrand(brand);
		this.setDiameter(diameter);
	}

    public String getBrand() {
        return brand;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
        
        

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wheel other = (Wheel) obj;
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        if (Double.doubleToLongBits(this.diameter) != Double.doubleToLongBits(other.diameter)) {
            return false;
        }
        return true;
    }

   

  
        
        
}
