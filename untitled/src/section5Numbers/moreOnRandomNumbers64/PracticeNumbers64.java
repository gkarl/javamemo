package section5Numbers.moreOnRandomNumbers64;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Section 5 - 64 More on Random Numbers
 */
class PracticeNumbers64 {

    public static void main(String[] args) {

        //________________________Methode 1________________________
        System.out.println((int)(Math.random() * 10)); // Math.random() => Methode vue dans la leçon précédente | distribution pas très uniforme des nombres aléatoires
        System.out.println((int)(Math.random() * 10));
        System.out.println((int)(Math.random() * 10));
        System.out.println((int)(Math.random() * 10));

        //________________________Methode 2________________________
        Random random = new Random();
        System.out.println(random.nextInt(10)); // Random => Class à instancier | nextInt() => Methode qui return des int randomisé EX [0, 9] | Approche pas considérée comme adaptée aux cas hautement sécuriser des choses comme le cryptage
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));

        //________________________Methode 3________________________
        SecureRandom random1 = new SecureRandom();   //  SecureRandom => Class à instancier | nextInt() => Methode qui return des int randomisé EX [0, 9] | Approche considérée comme adaptée aux cas hautement sécuriser des choses comme le cryptage
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
    }
}
