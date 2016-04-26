package topic0.AbstractFactory;

public class MariaConnection extends Others {

	public String getConnection(){
		return "Maria Connection Ready";
	}
	
	public String releaseConnection(){
		return "Maria Connection Released";
	}
}
