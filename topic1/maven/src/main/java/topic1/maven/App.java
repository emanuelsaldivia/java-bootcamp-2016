package topic1.maven;

/**
 * Hello world!
 *
 */
public class App 
{
	private int a;
	private int b;
	
    public App(int a, int b) {
    	this.a=a;
    	this.b=b;
	}
	
    public int bigger(){
    	if (a>b){
    		return a;
    	}
    	else{
    		return b;
    	}
    }
    
    public int lower(){
    	if (a<b){
    		return a;
    	}
    	else {
    		return b;
    	}
    }
}
