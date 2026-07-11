package chap07.sect3;

import java.util.ArrayList;

/**
 * Demonstrates basic operations of the ArrayList class.
 *
 * @author Drue Coles
 */
public class AnimalList {

   public static void main(String[] args) {
      ArrayList<String> animals = new ArrayList<>();
      animals.add("ant");
      animals.add("bat");
      animals.add("cow");
      animals.add("fox");
      animals.add("yak");
      System.out.println(animals);

      animals.add(2, "emu");
      System.out.println(animals);

      animals.set(3, "pig");
      System.out.println(animals);

      animals.remove(3);
      System.out.println(animals);

      animals.remove("fox");
      System.out.println(animals);
   }
}
