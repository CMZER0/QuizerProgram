import java.util.Scanner;

public class Main {
    static int numOfCorrect = 0;
    static int numOfIncorrect = 0;

    public static void main(String args[]) {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        reportScore();
    }

    private static void reportScore() {
        System.out.println("Your score was:" + numOfCorrect + "/" + (numOfCorrect + numOfIncorrect));
        System.exit(0);
    }

    public static void doMethods(Orchestra o, int i, int q) {
        switch (i) {
            case 0:
                try {
                    testLogic(o.playMusic(), "o.playMusic();", q);
                    o.playMusic();
                } catch (Exception e) {
                    testLogic("Err.", "o.playMusic();", q);
                    System.out.println("Err.");
                }
                break;
            case 1:
                try {
                    testLogic(o.practiceLoudly(), "o.practiceLoudly();", q);
                    o.practiceLoudly();
                } catch (Exception e) {
                    testLogic("Err.", "o.practiceLoudly();", q);
                    System.out.println("Err.");
                }
                break;
            case 2:
                try {
                    testLogic(((Viola) o).practiceLoudly(), "((Viola)o).practiceLoudly();", q);
                    ((Viola) o).practiceLoudly();
                } catch (Exception e) {
                    testLogic("Err.", "((Viola)o).practiceLoudly();", q);
                    System.out.println("Err.");
                }
                break;
            case 3:
                try {
                    testLogic(((Viola) o).beImpressive(), "((Viola)o).beImpressive();", q);
                    ((Viola) o).beImpressive();
                } catch (Exception e) {
                    testLogic("Err.", "((Viola)o).beImpressive();", q);
                    System.out.println("Err.");
                }
                break;
        }
    }

    public static void testLogic(String key, String line, int q) {
        Scanner u = new Scanner(System.in);
        System.out.println("What will the following line print?\n \n" + line
                + "\n \nA) Duuuu duuuu du du du duuuu duuuu du du du duuuu duuuu du du du duuuu. \nB) *A loud mix of instruments play.* \nC) *A sweet viola solo fills the room.* \nD) Im a Viola, how am I not impressive?! \nE) Err.");
        String choice = u.next();
        String[] temp = { "Duuuu duuuu du du du duuuu duuuu du du du duuuu duuuu du du du duuuu.",
                "*A loud mix of instruments play.*", "*A sweet viola solo fills the room.*",
                "Im a Viola, how am I not impressive?!", "Err." };
        String answer = "Err.";
        if (q != 4) {
            if (choice.equalsIgnoreCase("a")) {
                answer = temp[0];
            } else if (choice.equalsIgnoreCase("b")) {
                answer = temp[1];
            } else if (choice.equalsIgnoreCase("c")) {
                answer = temp[2];
            } else if (choice.equalsIgnoreCase("d")) {
                answer = temp[3];
            } else if (choice.equalsIgnoreCase("e")) {
                answer = temp[4];
            }
        } else {
            key = "Err.";
        }
        if (answer.equals(key)) {
            space();
            System.out.println("That was correct!");
            numOfCorrect += 1;
        } else {
            space();
            System.out.println("Sory, that was incorrect");
            numOfIncorrect += 1;
        }
        System.out.println("The output was: " + key + "\n");
    }

    public static void questionOne() {
        Orchestra o = new Orchestra();
        System.out.println("Given the following code: \n\nOrchestra o = new Orchestra();\n");
        for (int i = 0; i < 4; i++) {
            doMethods(o, i, 1);
        }
    }

    public static void questionTwo() {
        Orchestra o = new Viola();
        System.out.println("Given the following code: \n\nOrchestra o = new Viola();\n");
        for (int i = 0; i < 4; i++) {
            doMethods(o, i, 2);
        }
    }

    public static void questionThree() {
        Viola o = new Viola();
        System.out.println("Given the following code: \n\nViola o = new Viola();\n");
        for (int i = 0; i < 4; i++) {
            doMethods(o, i, 3);
        }
    }

    public static void questionFour() {
        // Viola o = new Orchestra();
        Orchestra o = new Orchestra();
        System.out.println("Given the following code: \n\nViola o = new Orchestra();\n");
        for (int i = 0; i < 4; i++) {
            doMethods(o, i, 4);
        }
    }

    public static void space() {
        for (int i = 0; i <= 100; i++) {
            System.out.println();
        }
    }
}