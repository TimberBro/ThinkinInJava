package com.test.polymorphism;

class Glyph{
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph{
    private int radius = 1;
    RoundGlyph(int r){
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw(){
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph{
    private int aSide = 2;
    private int bSide = 6;
    RectangularGlyph(int a, int b){
        aSide = a;
        bSide = b;
        System.out.println("RectangularGlyph.RectangularGlyph(), aSide = " + aSide + ", bSide = " + bSide);
    }

    void draw() {
        System.out.println("RectangularGlyph.draw(), aSide = " + aSide + ", bSide = " + bSide);
    }
}

public class PolyConstructors {
    public static void main(String[] args){
        //new RoundGlyph(2);
        new RectangularGlyph(1,4);
    }
}
