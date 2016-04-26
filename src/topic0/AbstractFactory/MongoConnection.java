package topic0.AbstractFactory;



public class MongoConnection extends Others {

	public String getConnection (){
		return "Mongo Connection Ready";
	}
	
	public String releaseConnection (){
		return "Mongo Connection Realesed";
	}
}
