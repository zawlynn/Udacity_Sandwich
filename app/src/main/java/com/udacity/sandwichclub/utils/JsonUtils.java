package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    private static final String no_data = "Data not available";
    private static final String col_name = "name";
    private static final String col_also_know = "alsoKnownAs";
    private static final String col_main_name = "mainName";
    private static final String col_place_of_orgin = "placeOfOrigin";
    private static final String col_description = "description";
    private static final String col_image = "image";
    private static final String col_ingredients = "ingredients";
    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject _json = new JSONObject(json);
            if(_json.optJSONObject(col_name)!=null) {
                sandwich.setMainName(_json.optJSONObject(col_name).optString(col_main_name, no_data));
                if (_json.optJSONObject(col_name).optJSONArray(col_also_know) != null) {
                    ArrayList<String> name_list = new ArrayList<>();
                    for (int i = 0; i < _json.optJSONObject(col_name).getJSONArray(col_also_know).length(); i++) {
                        name_list.add(_json.optJSONObject(col_name).getJSONArray(col_also_know).getString(i));
                    }
                    sandwich.setAlsoKnownAs(name_list);
                }
            }
            sandwich.setPlaceOfOrigin(_json.optString(col_place_of_orgin, no_data));
            sandwich.setDescription(_json.optString(col_description, no_data));
            sandwich.setImage(_json.optString(col_image,no_data));

            if (_json.optJSONArray(col_ingredients) != null) {
                ArrayList<String> ingredients = new ArrayList<>();
                for (int i = 0; i < _json.getJSONArray(col_ingredients).length(); i++) {
                    ingredients.add(_json.getJSONArray(col_ingredients).getString(i));
                }
                sandwich.setIngredients(ingredients);
            }

        } catch (JSONException e) {
            sandwich = null;
        }
        return sandwich;
    }
}
