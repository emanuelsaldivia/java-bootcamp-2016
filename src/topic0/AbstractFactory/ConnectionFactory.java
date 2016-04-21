package topic0.AbstractFactory;

public abstract class ConnectionFactory {

	public abstract Db getDb(String type);
	
}
