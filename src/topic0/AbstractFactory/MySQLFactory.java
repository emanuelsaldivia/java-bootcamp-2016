package topic0.AbstractFactory;

public class MySQLFactory extends ConnectionFactory {

	@Override
	public Db getDb(String type) {
		if ("MySQL".equals(type)) {
			return new MySQLConnection();
		}
	}
	
}

