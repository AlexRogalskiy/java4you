package com.sensiblemetrics.api.alpenidos.pattern.type_object.model;

import com.sensiblemetrics.api.alpenidos.pattern.type_object.parser.JsonParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

/**
 * The CellPool class allows the reuse of crushed cells instead of creation of new
 * cells each time. The reused cell is given a new candy to hold using the randomCode
 * field which holds all the candies available.
 */
public class CellPool {
    private ArrayList<Cell> pool;
    private int pointer;
    private Candy[] randomCode;

    public CellPool(int num) {
        this.pool = new ArrayList<>(num);
        try {
            this.randomCode = this.assignRandomCandytypes();
        } catch (Exception e) {
            e.printStackTrace();
            //manually initialising this.randomCode
            this.randomCode = new Candy[5];
            randomCode[0] = new Candy("cherry", "fruit", Candy.Type.rewardFruit, 20);
            randomCode[1] = new Candy("mango", "fruit", Candy.Type.rewardFruit, 20);
            randomCode[2] = new Candy("purple popsicle", "candy", Candy.Type.crushableCandy, 10);
            randomCode[3] = new Candy("green jellybean", "candy", Candy.Type.crushableCandy, 10);
            randomCode[4] = new Candy("orange gum", "candy", Candy.Type.crushableCandy, 10);
        }
        for (int i = 0; i < num; i++) {
            final Cell c = new Cell();
            Random rand = new Random();
            c.setCandy(this.randomCode[rand.nextInt(this.randomCode.length)]);
            this.pool.add(c);
        }
        this.pointer = num - 1;
    }

    public Cell getNewCell() {
        final Cell newCell = this.pool.remove(this.pointer);
        this.pointer--;
        return newCell;
    }

    public void addNewCell(final Cell c) {
        final Random rand = new Random();
        c.setCandy(this.randomCode[rand.nextInt(this.randomCode.length)]); //changing candytype to new
        this.pool.add(c);
        this.pointer++;
    }

    public Candy[] assignRandomCandytypes() throws IOException, ParseException {
        final JsonParser jp = new JsonParser();
        jp.parse();
        final Candy[] randomCode = new Candy[jp.getCandies().size() - 2]; //exclude generic types 'fruit' and 'candy'
        int i = 0;
        for (final Enumeration<String> e = jp.getCandies().keys(); e.hasMoreElements(); ) {
            final String s = e.nextElement();
            if (!s.equals("fruit") && !s.equals("candy")) {
                randomCode[i] = jp.getCandies().get(s);
                i++;
            }
        }
        return randomCode;
    }
}
