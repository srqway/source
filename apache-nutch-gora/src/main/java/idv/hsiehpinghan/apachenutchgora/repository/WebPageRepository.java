package idv.hsiehpinghan.apachenutchgora.repository;

import org.apache.gora.query.Query;
import org.apache.gora.query.Result;
import org.apache.gora.store.DataStore;
import org.apache.nutch.storage.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WebPageRepository {
	@Autowired
	private DataStore<String, WebPage> dataStore;

	public Result<String, WebPage> query(String key, String[] fields) {
		Query<String, WebPage> query = dataStore.newQuery();
		query.setKey(key);
		query.setFields(fields);
		return query.execute();
	}

	public Result<String, WebPage> query(String startKey, String[] fields,
			long limit) {
		Query<String, WebPage> query = dataStore.newQuery();
		query.setStartKey(startKey);
		query.setFields(fields);
		query.setLimit(limit);
		return query.execute();
	}
}
