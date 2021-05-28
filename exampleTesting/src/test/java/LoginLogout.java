import java.lang.reflect.Method;

import org.testng.annotations.Test;

import Functionalities.Functionalities;
import Functionalities.Keywords;

public class LoginLogout {
	
	Functionalities obj=new Functionalities();
	Keywords k=new Keywords();
	
	
  @Test(priority=1)
public void login() {
	  obj.Initialize();
	  for(String keyword:k.loginKeywords) {
		  try {
			Method method=obj.getClass().getMethod(keyword);
			method.invoke(obj);
		} catch (Exception e) {
			System.out.println(e);
		}
		  
	  }
	 
  }
  
  @Test(priority=2)
  public void logout() {
  	  obj.Initialize();
  	  for(String keyword:k.logoutKeywords) {
  		  try {
  			Method method=obj.getClass().getMethod(keyword);
  			method.invoke(obj);
  		} catch (Exception e) {
  			System.out.println(e);
  		}
  		  
  	  }
  	 
    }
  
  
  
}
