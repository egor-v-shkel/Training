package CodeWars;

public class EasyWallpaper {

    public String wallpaper(double l, double w, double h) {
        if (l == 0 || w == 0 || h == 0) return "zero";
        final double ROLL_WIDTH = 0.52;
        final double ROLL_LENGTH = 10;
        double square = 2*(l+w)*h;
        double commonRollLength = square/ROLL_WIDTH*1.15;
        int rollNum = (int) Math.ceil(commonRollLength / ROLL_LENGTH);
        String rollStr = "";
        switch (rollNum) {
            case 1:  rollStr = "one";
                break;
            case 2:  rollStr = "two";
                break;
            case 3:  rollStr = "three";
                break;
            case 4:  rollStr = "four";
                break;
            case 5:  rollStr = "five";
                break;
            case 6:  rollStr = "six";
                break;
            case 7:  rollStr = "seven";
                break;
            case 8:  rollStr = "eight";
                break;
            case 9:  rollStr = "nine";
                break;
            case 10:  rollStr = "ten";
                break;
            case 11:  rollStr = "eleven";
                break;
            case 12:  rollStr = "twelve";
                break;
            case 13:  rollStr = "thirteen";
                break;
            case 14:  rollStr = "fourteen";
                break;
            case 15:  rollStr = "fifteen";
                break;
            case 16:  rollStr = "sixteen";
                break;
            case 17:  rollStr = "seventeen";
                break;
            case 18:  rollStr = "eighteen";
                break;
            case 19:  rollStr = "nineteen";
                break;
            case 20:  rollStr = "twenty";
                break;
        }
        return rollStr;
    }
}