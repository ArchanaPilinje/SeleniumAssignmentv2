import java.lang.reflect.Method;

import org.testng.annotations.Test;

import Functionalities.Functionalities;
import Functionalities.Keywords;

public class AddToCart {
	Functionalities obj=new Functionalities();
	Keywords k=new Keywords();
	
	
  @Test
  public void AddToCart() {
	  obj.Initialize();
  	  for(String keyword:k.searchAndBuyMobileKeywords) {
  		  try {
  			Method method=obj.getClass().getMethod(keyword);
  			method.invoke(obj);
  		} catch (Exception e) {
  			System.out.println(e);
  		}
  		  
  	  }
  	 
    }
	  
  }

