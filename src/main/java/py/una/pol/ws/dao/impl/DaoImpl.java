package py.una.pol.ws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import py.una.cnc.lib.db.DataSourcePool;
import py.una.cnc.lib.db.dataprovider.SQLExecuter;
import py.una.cnc.lib.db.dataprovider.SQLToObject;
import py.una.pol.ws.main.AppObjects;

@Repository
public class DaoImpl {

	protected static final String ds = "java:jboss/datasources/vacunas";
	@Autowired
	private AppObjects appObjects;

	protected DataSourcePool getDsPool() {
		return appObjects.getDataSourcePool();
	}

	public <L> List<L> getListFromSQL(String dataSource, String sql, Class<L> clazz, Object... params) {

		SQLToObject<L> sqlToObject = new SQLToObject<>(appObjects.getDataSourcePool());
		sqlToObject.setRecordClass(clazz);
		try {
			return sqlToObject.createList(dataSource, sql, params);
		} catch (Exception ex) {

			return new ArrayList<>();
		}
	}

	public <L> List<L> getListFromSQL(Class<L> clazz, String sql, Object... params) {

		return getListFromSQL(ds, sql, clazz, params);
	}

	public <L> L getObjectFromSQL(String sql, Class<L> clazz, Object... params) {

		SQLToObject<L> sqlToObject = new SQLToObject<>(appObjects.getDataSourcePool());
		sqlToObject.setRecordClass(clazz);
		try {
			return sqlToObject.getItem(ds, sql, params);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void create(String sql, Object... params) {
		SQLExecuter executer = new SQLExecuter(getDsPool());
		executer.execute(ds, sql, params);
	}

}
