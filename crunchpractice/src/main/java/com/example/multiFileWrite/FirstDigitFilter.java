package com.example.multiFileWrite;

import org.apache.crunch.FilterFn;

/**
 * created by ravibhushan.k on 01/09/18
 */
public class FirstDigitFilter extends FilterFn<String > {

    private String value;
    FirstDigitFilter(String value){
        this.value=value;
    }

    @Override
    public boolean accept(String line) {
        String local=""+line.charAt(0);
        if(local.equals(value)) {
            return true;
        }
        return false;
    }
}
