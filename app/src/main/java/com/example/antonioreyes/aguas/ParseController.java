package com.example.antonioreyes.aguas;

import com.parse.ParseObject;
import com.parse.ParseException;
import com.parse.SaveCallback;

public class ParseController {

    private ParseObject reportObject;

    public ParseController(String report){
        this.reportObject = new ParseObject(report);
    }

    public void put(String key, String value){
        this.reportObject.put(key, value);
    }

    public void saveParse(){
        this.reportObject.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    //Success
                    //return true;
                } else {
                    //Error
                    //return false;
                }
            }
        });
    }
}
