package section2ClassObjetMethode.staticInitializers18;

/**
 * Section 2 - 18 Static Initializers
 *
 * rare d'utilisation
 *
 */
class Person {

    // **********Methode 1*************
    public static int[] nums;  // static variable

    static { //c'est ce qu'on appelle un initialiseur static. C'est presque comme une méthode anonyme,
        nums = new int[5];
        nums[0] = 3;  // ça nous permet de valoriser notre variable static ce qui aurait été difficile de le faire sur une seul ligne
        nums[1] = 3;
        nums[2] = 3;
        nums[3] = 3;
        nums[4] = 3;
    }

    // **********Methode 2*************
    // Alternative (il préfére)
    public static int[] nums2 = initNums2();

    public static int[] initNums2() {
        int[] nums2 = new int[5];
        nums2[0] = 3;
        nums2[1] = 3;
        nums2[2] = 3;
        nums2[3] = 3;
        nums2[4] = 3;
        return nums2;
    }
}
