package com.sensiblemetrics.api.alpenidos.pattern.type_object.parser;

import com.sensiblemetrics.api.alpenidos.pattern.type_object.model.Candy;
import lombok.Data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * The JsonParser class helps parse the json file candy.json to get all the
 * different candies.
 */
@Data
public class JsonParser {
    private Hashtable<String, Candy> candies;

    public JsonParser() {
        this.candies = new Hashtable<>();
    }

    public void parse() throws IOException, ParseException {
        final JSONParser parser = new JSONParser();
        final JSONObject jo = (JSONObject) parser.parse(new FileReader(new File("").getAbsolutePath() + "candy.json"));
        final JSONArray a = (JSONArray) jo.get("candies");
        for (final Object o : a) {
            final JSONObject candy = (JSONObject) o;
            final String name = (String) candy.get("name");
            final String parentName = (String) candy.get("parent");
            final String t = (String) candy.get("type");
            Candy.Type type = null;
            if (t.equals("rewardFruit")) {
                type = Candy.Type.rewardFruit;
            } else {
                type = Candy.Type.crushableCandy;
            }
            int points = Integer.parseInt((String) candy.get("points"));
            Candy c = new Candy(name, parentName, type, points);
            this.candies.put(name, c);
        }
        this.setParentAndPoints();
    }

    private void setParentAndPoints() {
        for (final Enumeration<String> e = this.candies.keys(); e.hasMoreElements(); ) {
            final Candy c = this.candies.get(e.nextElement());
            if (c.getParentName() == null) {
                c.setParent(null);
            } else {
                c.setParent(this.candies.get(c.getParentName()));
            }
            if (c.getPoints() == 0 && c.getParent() != null) {
                c.setPoints(c.getParent().getPoints());
            }
        }
    }
}
