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

	public Result<String, WebPage> query(String key) {
		Query<String, WebPage> query = dataStore.newQuery();
		query.setKey(key);
		return query.execute();
	}

	public Result<String, WebPage> query(String startKey, long limit) {
		Query<String, WebPage> query = dataStore.newQuery();
		query.setStartKey(startKey);
		query.setLimit(limit);
		return query.execute();
	}
}
