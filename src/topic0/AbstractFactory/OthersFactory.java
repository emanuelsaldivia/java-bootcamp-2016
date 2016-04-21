package topic0.AbstractFactory;

public class OthersFactory extends ConnectionFactory {

	@Override
	public Db getDb(String type) {
		if ("Others".equals(type)) {
			return new OthersConnection();
		}
	}

}
