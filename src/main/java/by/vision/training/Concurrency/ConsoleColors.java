package by.vision.training.Concurrency;

import java.util.Random;

public class ConsoleColors {

    public static ColorRandomiser randomiser = new ColorRandomiser();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static class ColorRandomiser{
        Random random = new Random();
        int color;
        int background;
        String randomLayout;

        private void randomise() {
            color = randomColorNum();
            background = randomColorNum();
            checkReadability(color, background);
        }

        private void checkReadability(int color, int background){
            if (color == background) checkReadability(color, randomColorNum());
            this.color = color;
            this.background = background;
        }

        private int randomColorNum() {
            return random.nextInt(8);
        }

        public String colorLayout() {
            randomise();
            randomLayout = String.format("\u001B[3%s;4%s;1m", color, background);
            return randomLayout;
        }

        public String colorText(){
            randomise();
            return String.format("\u001B[3%sm", color);
        }
    }

}
