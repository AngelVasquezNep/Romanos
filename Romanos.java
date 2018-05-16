import java.util.Scanner;

public class Romanos {
  
  public static Scanner entrada = new Scanner(System.in);
  public static String numRomUser = new String();
  public static char[] arrayRom = {};
  public static String[] valueRomByArray = {};
  public static byte auxContador = 0;

  public static void main (String[] args) {
    System.out.println("Bienvenido");
    System.out.print("Por favor ingrese un número romano: ");
    numRomUser = entrada.nextLine();
    repeat();
  }

  public static void repeat() {
    arrayRom = numRomUser.toCharArray();

    if (arrayRom.length > 1) {
      
      // boolean igual;
      
      for (byte i = 0; (i + 1) < arrayRom.length; i++ ) {
        if( arrayRom[i] == arrayRom [i + 1] ) {
          System.out.println("Dos letras iguales: " + arrayRom[i]);
          if( (i + 2) < arrayRom.length && arrayRom[i + 1] == arrayRom [i + 2] ) {
            System.out.println("Tres letras iguales: " + arrayRom[i]);

            if( (i + 3) < arrayRom.length && arrayRom[i + 2] == arrayRom [i + 3] ) {
              System.out.println("Error, más  de 3 letras iguales");
              System.out.println("Salir ");
              System.exit(1);
            }
          }
        } else {
          System.out.println("--");
        }
      }
      
    } else {
      System.out.println("Sin igualdades");
      // Colocar valor de la letra que se haya ingresado
      // ToDo Verificar que sólo se ingresen letras validas
    }
  }
}
