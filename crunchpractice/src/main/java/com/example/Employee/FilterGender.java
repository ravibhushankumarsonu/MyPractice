package com.example.Employee;

import org.apache.crunch.FilterFn;

/**
 * created by ravibhushan.k on 01/09/18
 */
public class FilterGender extends FilterFn<Employee> {
    private String key;

    public FilterGender(String key) {
        this.key = key;
    }

    @Override
    public boolean accept(Employee employee){

        if(key.equals(employee.getGender().toString())) {
            return true;
        }
        return false;
    }
}
