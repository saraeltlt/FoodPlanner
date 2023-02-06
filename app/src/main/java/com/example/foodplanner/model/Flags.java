package com.example.foodplanner.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Flags {
    public static  Map<String, String> FLAGS_MAP;

    // Instantiating the static map
    static
    {
        FLAGS_MAP = new HashMap<>();
        FLAGS_MAP.put("Malaysian", "malaysian.png");
        FLAGS_MAP.put("Vietnamese", "vietnamese.png");
    }

}
