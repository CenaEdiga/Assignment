package testing;


public class palendrome {
      public static boolean Palen(String s){
		String rev="";
		for(int i=s.length()-1;i>=0;i--){
			rev=rev+s.charAt(i);
		}
		if(s.equals(rev))
			return true;
			else
			return false;
		
		
		}
	  
}
 

