package topic0.AbstractFactory;

import java.sql.Connection;

public abstract class SQL {

	public abstract Connection getConnection();
	public abstract void releaseConnection();
}
