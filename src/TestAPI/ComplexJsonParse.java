package TestAPI;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. Print No of courses returned by API
		
		JsonPath cj=new JsonPath(payload.CoursePrice());
		int count=cj.getInt("courses.size()");
		System.out.println(count);
		
		//2.Print Purchase Amount

          int TotalAmount	=cj.getInt("dashboard.purchaseAmount");	
          System.out.println(TotalAmount);

         // 3. Print Title of the first course
          
          String firstCourseName=cj.get("courses[0].title");
          System.out.println(firstCourseName);
          
          //4. Print All course titles and their respective Prices
           
         for(int i=0;i<count;i++)
         {
        	 String coursename=cj.get("courses["+i+"].title");
        	 System.out.println(cj.get("courses["+i+"].price").toString());
        	 System.out.println(coursename);
         }
         
        // 5. Print no of copies sold by RPA Course
         System.out.println(" Print no of copies sold by RPA Course");
         for(int i=0;i<count;i++)
         {
        	 String coursename=cj.get("courses["+i+"].title");
        	 if(coursename.equalsIgnoreCase("RPA"))
        	 {
        		 int copies=cj.get("courses["+i+"].copies");
        		 System.out.println(copies);
        		 break;
        	 }
         }
         
         //6. Verify if Sum of all Course prices matches with Purchase Amount
         
         
         
         
         
         }
	}


