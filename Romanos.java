import java.util.Scanner;

import com.sun.tools.javac.comp.Todo;






public class Romanos {
  
  public static Scanner entrada = new Scanner(System.in);
  public static String numRomUser = new String();
  public static char[] arrayRom = {};
  public static String[] valueRomByArray = {};

  public static void main (String[] args) {
    System.out.println("Bienvenido");
    System.out.println("Por favor ingrese un número romano: ");
    numRomUser = entrada.nextLine();
    repeat();
  }
  
  public static boolean repeat() {
    arrayRom = numRomUser.toCharArray();

    // case 1 => Sin coincidencias => Guardar en valueRom[0]
    if (arrayRom.length > 1) {
        
      for (byte i = 0; (i + 1) < arrayRom.length; i++ ) {
        
      }

    } else {
      // Colocar valor de la letra que se haya ingresado
      // ToDo Verificar que sólo se ingresen letras validas
    }

    // case 2 => Una coincidencia => Guardar en valueRom[1]
    // arrayRom[i] == arrayRom[i+1]
    // case 3 => Dos coincidencia => Guardar en valueRom[2]
    // arrayRom[i] == arrayRom[i+1] == arrayRom[i+2]
    if( arrayRom[0] == arrayRom[1] ) {
      System.out.println("Iguales");
    } else {
      System.out.println("Diferentes");
    }
    
    return 1 > 2;
  }
}
