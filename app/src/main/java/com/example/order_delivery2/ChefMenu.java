package com.example.order_delivery2;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("ChefMenu")
public class ChefMenu extends ParseObject {
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_IMAGE = "image";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String Description){
        put(KEY_DESCRIPTION, Description);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }
}