package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zsu00 on 4/25/2017.
 */
public class SeattleSchoolsData {
    String fileName;
    ArrayList<String> schoolArray;
    ArrayList<Double> latArray;
    ArrayList<Double> longArray;

    Map<String,String> phoneMap;
    Map<String,String> addressMap;


    public SeattleSchoolsData (String fileName) {
        this.fileName = fileName;
        schoolArray = new ArrayList<String>();
        latArray = new ArrayList<Double>();
        longArray = new ArrayList<Double>();
        addressMap = new HashMap<String,String>();
        phoneMap = new HashMap<String,String>();
    }

    //Scan whole file for each line
    public void fileProcess()throws FileNotFoundException{
        Scanner input = new Scanner(new File(this.fileName));
        if(input.hasNextLine()){
            input.nextLine(); //ignore the first line
        }

        while(input.hasNextLine()) {
            String line = input.nextLine();
            String[] textArray = line.split(",");

            //store each school's information in corresponding arraylist
            String address = textArray[6];
            String phone = textArray[9];
            String schoolName = textArray[11];

            schoolArray.add(schoolName);
            phoneMap.put(schoolName,phone);
            addressMap.put(schoolName,address);

            latArray.add(Double.parseDouble(textArray[1]));
            longArray.add(Double.parseDouble(textArray[2]));
        }
    }




    //get distance
    //input: string -- school name
    //output:  map
    public Map<String,Double> getDistances(String name){
        Map<String,Double> distanceMap = new HashMap<String,Double>();
        ZipLookup zip = new ZipLookup();
        //find coordinates of given school
        int index2 = schoolArray.indexOf(name);
        double lat2 = latArray.get(index2);
        double long2 = longArray.get(index2);

        //find distance between two schools and put in map
        for( String schoolName : schoolArray){
            int index1 = schoolArray.indexOf(schoolName);
            double lat1 = latArray.get(index1);
            double long1 = longArray.get(index1);
            double distance = zip.distance(lat2,long2,lat1,long1);
            if(distance > 0) {
                distanceMap.put(schoolName, distance);
            }
        }

        return distanceMap;
    }

    //getSchoolName
    public ArrayList<String> getSchoolName(){
        return schoolArray;
    }

    //getPhoneBook
    public Map<String,String>getPhoneBook(){
        return phoneMap;
    }

    //getAddressBook
    public Map<String,String>getAddressBook(){
        return addressMap;
    }



}
