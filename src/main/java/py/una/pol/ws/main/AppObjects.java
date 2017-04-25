package py.una.pol.ws.main;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import py.una.cnc.lib.db.DataSourcePool;
import py.una.cnc.lib.db.dataprovider.SQLSource;

@Component
public class AppObjects {

	private SQLSource sqlSource;
	private DataSourcePool dataSourcePool;

	@PostConstruct
	public void init() {
		sqlSource=new SQLSource();
		dataSourcePool = new DataSourcePool();
		dataSourcePool.init();
	}

	public SQLSource getSqlSource() {
		return sqlSource;
	}

	public DataSourcePool getDataSourcePool() {
		return dataSourcePool;
	}

}
