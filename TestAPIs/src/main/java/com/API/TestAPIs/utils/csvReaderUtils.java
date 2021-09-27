package com.API.TestAPIs.utils;

import com.fasterxml.jackson.dataformat.csv.*;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class csvReaderUtils {

    private static csvReaderUtils csvReaderUtils;
    private static BufferedReader reader = null;

    private csvReaderUtils(String fileName){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if(inputStream!=null)
            reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public static csvReaderUtils getInstance(String fileName) throws IOException {
        synchronized (csvReaderUtils.class) {
            try {
                csvReaderUtils = new csvReaderUtils(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return csvReaderUtils;

    }

   public static ArrayList<Object[]> parseCSV() throws IOException {
        ArrayList<Object[]> myData = new ArrayList<>();
       StringBuilder lines = new StringBuilder();
       String lineSeparator = System.getProperty("line.separator");
       for (String r = reader.readLine(); r != null; r = reader.readLine()) {
           lines.append(r).append(lineSeparator);
       }
       CsvMapper csvMapper = new CsvMapper();
       CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();

       // Read data from CSV file
       List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(lines.toString()).readAll();
       Gson gson = new Gson();
       String testData = gson.toJson(readAll);
       JSONArray array = new JSONArray(testData);
       Set<String> keyNames = array.getJSONObject(0).keySet();
       for(int i=0; i < array.length(); i++){
           JSONObject jsonObject = array.getJSONObject(i);
           Iterator<String> keys = jsonObject.keys();
           int index = 0;
           Object[] values = new Object[keyNames.size()];
           while (keys.hasNext()){
               String key = keys.next();
               Object value = jsonObject.get(key);
               values[index++] = value;
           }
           myData.add(values);
       }
       return myData;

   }
}
