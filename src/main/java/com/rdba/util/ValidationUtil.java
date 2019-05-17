package com.rdba.util;

import com.rdba.util.exception.NotFoundException;

public class ValidationUtil {
    public static <T> T checkNotFoundWithId(T o, int id){
        if (o == null){
            throw new NotFoundException("Not found with id = " + id);
        }
    return o;
    }



}
