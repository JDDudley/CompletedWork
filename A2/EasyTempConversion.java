public class EasyTempConversion {
  public static void main(String[] args)
  {
    int degreesF;
    int degreesC;
    
    degreesF = 100;
    
    degreesC = (degreesF - 32)  * 5/9;
    
    System.out.println(degreesF + "F is " + degreesC + "C.");
    
  }
}