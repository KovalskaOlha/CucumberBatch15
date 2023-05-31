package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    // we will pass the body in multiple formats

    public static String createEmployeePayload(){
        String createEmployeePayload="{\n" +
                "    \"emp_firstname\": \"Sam\",\n" +
                "    \"emp_lastname\": \"Johns\",\n" +
                "    \"emp_middle_name\": \"J\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"1990-05-20\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"Engineer\"\n" +
                "}";
        return createEmployeePayload;
    }

          public static String createEmployeePayloadJson(){
              JSONObject obj=new JSONObject();
              obj.put("emp_firstname","Sam");
              obj.put("emp_lastname","Johns");
              obj.put("emp_middle_name","J");
              obj.put("emp_gender","M");
              obj.put("emp_birthday","1990-05-20");
              obj.put("emp_status","Confirmed");
              obj.put("emp_job_title","Engineer");
              return obj.toString();
        }

    public static String createEmployeePayloadDynamic
            (String emp_firstname,String emp_lastname,String emp_middle_name,
             String emp_gender, String emp_birthday, String emp_status,
             String emp_job_title){

        JSONObject obj=new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("employee_id","57582A");
        obj.put("emp_firstname","Britney");
        obj.put("emp_lastname","Spears");
        obj.put("emp_middle_name","JJ");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","1992-06-21");
        obj.put("emp_status","Retired");
        obj.put("emp_job_title","Singer");
        return obj.toString();
    }
}
