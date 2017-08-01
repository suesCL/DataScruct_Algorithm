package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        SeattleSchoolsData s = new SeattleSchoolsData("seattlepublicschool.txt");
        s.fileProcess();

        //Question 1
        sortSchoolsByPhone(s);

        //Question 2
        //The answers [Denny Int'l, Hughes, Roxhill, Sanislo, Highland Park]
        fiveSchools("Chief Sealth Int'l", s);

        //Question 3
        //find school on 28th Ave NW
        findSchoolFromAddress("28th Ave NW", s.getAddressBook());

        //Question 4
        findFarthestSchool(s);

    }

    //print list of schools and phone number, sorting list of school in ascending phone number
    public static void sortSchoolsByPhone(SeattleSchoolsData s){
        Map reverseMap = new TreeMap<Integer,String>();
        for(Map.Entry entry : s.getPhoneBook().entrySet()){
            //convert phone number to integer
            String num = (String)entry.getValue();
            int intNum;
            if(num.length() > 0){
                String newNum = num.replaceAll("\\D+","");
                intNum = Integer.valueOf(newNum);
            }else{
                intNum = 0;
            }

            //Add integer phone number and school name to treeMap for ordering
            reverseMap.put(intNum, entry.getKey());
        }

        System.out.println("The list schools sorting by phone number");
        System.out.println(reverseMap); //has to leave it this way with phone number being key to maintain order
    }

    //list names of 5 schools that are closest to given school
    public static void fiveSchools(String name, SeattleSchoolsData s){

        Map distanceMap = s.getDistances(name);
        Map reverseMap = new TreeMap<Double, String>();
        //Use treeSet to store relations, distance is key, exclude the given school
        for(Object key : distanceMap.keySet()){
            reverseMap.put(distanceMap.get(key),key);
        }

        //store first five schools in an list for accessing top 5
        ArrayList<String> schoolList = new ArrayList<String>();
        for(Object schoolName : reverseMap.values()){
            String school = (String)schoolName;
            schoolList.add(school);
        }

        List<String> fiveName = schoolList.subList(0,5);
        System.out.println("The five names that are closest to given school are below");
        System.out.println(fiveName);
    }


    //Find school name based on address
    public static void findSchoolFromAddress(String partialAddre, Map<String,String> map){
        //reverse key value pairs
        Map reverseMap = new HashMap<String,String>();
        for(Object key : map.keySet()){
            reverseMap.put(map.get(key),key);
        }

        for(Object key : reverseMap.keySet()){
            String address = (String)key;
            if(address.contains(partialAddre)){
                System.out.println("The school name is " + reverseMap.get(key));
                return;
            }
        }
    }


    //find schools that are farthest part and their distance
    public static void findFarthestSchool(SeattleSchoolsData s){
        //Store farthest distance for each school
        TreeMap<Double, String> farthestMap = new TreeMap<Double,String>();

        //find all distances for each school
        for(Object school : s.getSchoolName()){
            Map<String,Double> distanceMap = s.getDistances((String)school);
            TreeMap<Double,String> revertMap = new TreeMap<Double,String>();

            for(Object key : distanceMap.keySet()){
                revertMap.put(distanceMap.get(key),(String)key);
            }

            //find greatest distance for the school
            double farthestDistance = revertMap.lastKey();
            String farthestSchool = revertMap.get(farthestDistance);

            //create school name pair and put in treeMap
            String namePair = (String)school + " & " + farthestSchool;
            farthestMap.put(farthestDistance, namePair);
        }

        //System.out.println(farthestMap);
        // find greatest distance
        Double distance = farthestMap.lastKey();
        System.out.println("The two schools are " + farthestMap.get(distance) );
        System.out.println("The distance are " + distance);
    }



}
