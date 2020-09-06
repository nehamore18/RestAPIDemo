package TestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

@Test
public class sumofvalidation {

	
	public void sumvalidation()
	{
		int sum=0;
		JsonPath cj=new JsonPath(payload.CoursePrice());
		int count=cj.getInt("courses.size()");
		for(int i=0; i<count;i++)
		{
		int price=cj.getInt("courses["+i+"].price");
		 int copies=cj.getInt("courses["+i+"].copies");
		int amount=price*copies;
		System.out.println(amount);
		sum=sum+amount;
		
		}
		System.out.println(sum);
		  int TotalAmount	=cj.getInt("dashboard.purchaseAmount");	
	Assert.assertEquals(sum, TotalAmount);
	}
	
}
