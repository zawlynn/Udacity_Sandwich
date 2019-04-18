package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich=new Sandwich();
        try {
            JSONObject _json=new JSONObject(json);
            if (_json.getJSONObject("name") != null) {
                JSONObject _name=_json.getJSONObject("name");
                if(_name.getString("mainName")!=null){
                    sandwich.setMainName(_name.getString("mainName"));
                }if(_name.getJSONArray("alsoKnownAs")!=null){
                    ArrayList<String> name_list=new ArrayList<>();
                    for(int i=0;i<_name.getJSONArray("alsoKnownAs").length();i++){
                        name_list.add(_name.getJSONArray("alsoKnownAs").getString(i));
                    }
                    sandwich.setAlsoKnownAs(name_list);
                }
            }if(_json.getString("placeOfOrigin")!=null){
                sandwich.setPlaceOfOrigin(_json.getString("placeOfOrigin"));
            }if(_json.getString("description")!=null){
                sandwich.setDescription(_json.getString("description"));
            }if(_json.getString("image")!=null){
                sandwich.setImage(_json.getString("image"));
            }if(_json.getJSONArray("ingredients")!=null){
                ArrayList<String> ingredients=new ArrayList<>();
                for(int i=0;i<_json.getJSONArray("ingredients").length();i++){
                    ingredients.add(_json.getJSONArray("ingredients").getString(i));
                }
                sandwich.setIngredients(ingredients);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            sandwich=null;
        }
        return sandwich;
    }
}
