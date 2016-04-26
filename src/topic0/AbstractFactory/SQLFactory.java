package topic0.AbstractFactory;

public abstract class SQLFactory extends AbstractFactory {

	public SQL getSQL (String name){
		if (name.equalsIgnoreCase("mysql")){
			return MySQLConnection.getInstance();
		}
		if (name.equalsIgnoreCase("oracle")){
			return OracleConnection.getInstance();
		}
		return null;
	}
	
	public Others getNoSQL(String nombre) {
		return null;
	}
}

