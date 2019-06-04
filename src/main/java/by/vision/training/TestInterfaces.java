package by.vision.training;

import by.vision.training.Interfaces.Interface1;

public class TestInterfaces{
    public static void main(String args[]) {
        InterfaceImplement objIntFace = new InterfaceImplement();
        objIntFace.showInfo(10, 20);
        objIntFace.showSum(10, 20);
    }
}

class InterfaceImplement implements Interface1{
    //int i;
    //int j;
    @Override
    public void showInfo(int i, int j) {
        //this.i = i;
        //this.j = j;
        System.out.println(i);
        System.out.println(j);
    }

    @Override
    public void showSum(int i, int j) {
        //this.i = i;
        //this.j = j;
        System.out.println(i+j);
    }
}
