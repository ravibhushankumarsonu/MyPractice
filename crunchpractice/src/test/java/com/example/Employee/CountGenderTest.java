package com.example.Employee;

import org.apache.crunch.PCollection;
import org.apache.crunch.PGroupedTable;
import org.apache.crunch.PTable;
import org.apache.crunch.Pipeline;
import org.apache.crunch.impl.dist.collect.MRCollection;
import org.apache.crunch.impl.mem.MemPipeline;
import org.apache.crunch.types.writable.Writables;
import org.apache.zookeeper.data.Id;
import org.junit.Before;
import org.junit.Test;

import javax.sql.rowset.serial.SerialStruct;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * created by ravibhushan.k on 31/08/18
 */
public class CountGenderTest {

    @Test
    public void check(){
        String val = "Ravi";
        assertTrue(val.equals("Ravi"));
    }
    private List<String> datalist = new ArrayList<String>();
    private  CountGender countGender = null;

    @Before
    public void setUp() {
        datalist.add("1|24|M|consultant|85711");
        datalist.add("2|24|F|consultant|85711");
        datalist.add("3|24|M|consultant|85711");
        datalist.add("4|24|M|consultant|85711");
        datalist.add("5|24|F|consultant|85711");
        datalist.add("6|24|M|consultant|85711");
        datalist.add("7|24|F|consultant|85711");
        datalist.add("8|24|M|consultant|85711");
        datalist.add("9|24|M|consultant|85711");
        datalist.add("10|24|M|consultant|85711");
        datalist.add("11|24|F|consultant|85711");
        datalist.add("12|24|M|consultant|85711");
        datalist.add("13|24|M|consultant|85711");
        datalist.add("14|24|M|consultant|85711");
        datalist.add("15|24|M|consultant|85711");

        countGender = new CountGender();
        Pipeline pipeline = MemPipeline.getInstance();

    }

    @Test
    public void TestDateLsit() {
        assertNotNull(datalist);
        assertNotNull(countGender);
        System.out.println(datalist.size());
        System.out.println(datalist.get(0));
    }

    @Test
    public void PCollectionTest() {
        PCollection<String > pCollection = MemPipeline.collectionOf(datalist);
        assertNotNull(pCollection);
    }

    @Test
    public void TestPipeLine() {
        PCollection<String> inputData = MemPipeline.collectionOf(datalist);
        PCollection<Employee> employeePCollection = inputData.parallelDo(new SegregateGenderDoFn(), Writables.records(Employee.class));

        PTable<String , Integer> segregatedGenderData = employeePCollection.parallelDo(new Segregation(), Writables.tableOf(Writables.strings(), Writables.ints()));

        PGroupedTable<String ,Integer > segregatedGender = segregatedGenderData.groupByKey();

        PCollection<String > IdByGender = segregatedGender.parallelDo(new FinalSegregation(), Writables.strings());

        Iterable<String > values = IdByGender.materialize();

        for (String word: values) {
            System.out.println(word);
        }
        assertNotNull(values);
    }

}