
public class ComplexNumber {
    
    private double a, b;
    
    /**
     * Default constructor
     */
    public ComplexNumber(){
        this(0);
    }
    
    /**
     * Considers the imaginary part to be 0
     * @param a real part
     */
    public ComplexNumber(double a){
        this(a, 0);
    }
    
    /**
     * Initializes the complex number with both real and imaginary parts
     * @param a real part
     * @param b imaginary part
     */
    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    /**
     * 
     * @return returns the real part of the number
     */
    public double getA(){
        return this.a;
    }
    
    /**
     * 
     * @return returns the imaginary part of the number
     */
    public double getB(){
        return this.b;
    }
    
    /**
     * Adds two complex numbers
     * @param cm valid complex Number
     * @return returns the sum of the current complex number another one provided
     */
    public ComplexNumber sum(ComplexNumber cm){
        if(cm == null){
            throw new NullPointerException();
        }
        return new ComplexNumber(this.a + cm.a, this.b + cm.b);
    }
    
    /**
     * Performs subtraction of two complex numbers
     * @param cm valid complex number
     * @return returns the result of subtracting the current complex number with another one provided
     */
    public ComplexNumber subtract(ComplexNumber cm){
        if(cm == null){
            throw new NullPointerException();
        }
        return new ComplexNumber(this.a - cm.a, this.b - cm.b);
    }
    
    /**
     * Multiplies two complex numbers
     * @param cm valid complex number
     * @return returns the product of the current complex number with another one provided
     */
    public ComplexNumber multiply(ComplexNumber cm){
        if(cm == null){
            throw new NullPointerException();
        }
        return new ComplexNumber(this.a*cm.a + this.b*cm.b*-1, this.a*cm.b + this.b*cm.a);
    }
    
    /**
     * Divides two complex numbers
     * @param cm valid complex number
     * @return returns the result of dividing the current complex number by another one provided
     */
    public ComplexNumber divide(ComplexNumber cm){
        if(cm == null){
            throw new NullPointerException();
        }
        if(cm.a == 0 && cm.b == 0){
            throw new IllegalArgumentException();
        }
        // Conjugado del denominador
        ComplexNumber denConjugate = new ComplexNumber(cm.a, -cm.b);
        ComplexNumber numerator = this.multiply(denConjugate);
        ComplexNumber denominator = cm.multiply(denConjugate);
        return new ComplexNumber(numerator.a/denominator.a, numerator.b/denominator.a);
    }
    
    /**
     * Returns the string representation of the complex number
     */
    public String toString(){
        if(this.b == 0){    // Si mi parte imaginaria es 0
            return this.a + "";
        }
        if(this.a == 0){    // Si mi parte real es 0
            return "i"+this.b;
        }
        return String.format("%.2f + i%.2f", this.a, this.b);
    }
}
