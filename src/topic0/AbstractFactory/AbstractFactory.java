package topic0.AbstractFactory;

public class AbstractFactory {
	
	//La verdad que no supe bien como desarrollar este punto.
		
		public ConnectionFactory getConnectionFactory(String type) {
			if ("SQL".equals(type)) {
				return new MySQLFactory();
			} else {
				return new OthersFactory();
			}
		}
		
		
	}
