// This program will produce the verses of the song 
// "There was an old woman who swallowed a fly" with custom verse

// Creates a class/program named Song
public class Song {
    public static void main(String[] args) {
        swallowFly();
        swallowSpider();
        swallowBird();
        swallowCat();
        swallowDog();
        customVerse();
        womanDied();
    }

    // Prints out the last two lines of each verse
    public static void perhapsSheDie() {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
        System.out.println();

    }

    // Prints out the first verse of the Song
    public static void swallowFly() {
        System.out.println("There was an old woman who swallowed a fly.");
        perhapsSheDie();
    }

    // Prints out the second verse of the Song
    public static void swallowSpider() {
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        swallowSpiderReason();
    }

    // Prints out why the old woman swallowed the spider
    public static void swallowSpiderReason() {
        System.out.println("She swallowed the spider to catch the fly,");
        perhapsSheDie();
    }

    // Prints out the third verse of the Song
    public static void swallowBird() {
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        swallowBirdReason();
    }

    // Prints out why the old woman swallowed the bird
    public static void swallowBirdReason() {
        System.out.println("She swallowed the bird to catch the spider,");
        swallowSpiderReason();
    }

    // Prints out the fourth verse of the Song
    public static void swallowCat() {
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        swallowCatReason();
    }

    // Prints out why the old woman swallowed the cat
    public static void swallowCatReason() {
        System.out.println("She swallowed the cat to catch the bird,");
        swallowBirdReason();
    }

    // Prints out the fifth verse of the Song
    public static void swallowDog() {
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        swallowDogReason();
    }
    
    // Prints out why the old woman swallowed the dog
    public static void swallowDogReason() {
        System.out.println("She swallowed the dog to catch the cat,");
        swallowCatReason();
    }

    // Prints out the custom verse of the Song
    public static void customVerse() {
        System.out.println("There was an old woman who swallowed a elephant,");
        System.out.println("How ignorant to swallow an elephant.");
        System.out.println("She swallowed the elephant to catch the dog,");
        swallowDogReason();
    }

    // Prints out the last verse of the Song
    public static void womanDied() {
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }
}
