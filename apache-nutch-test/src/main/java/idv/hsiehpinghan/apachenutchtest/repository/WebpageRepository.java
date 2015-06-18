package idv.hsiehpinghan.apachenutchtest.repository;

import idv.hsiehpinghan.apachenutchtest.dto.WebpageData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Component;

@Component
public class WebpageRepository {
	private final String TABLE_NAME = "webpage";
	private final Configuration CONF = HBaseConfiguration.create();

	public WebpageData get(String rowKey) throws IOException {
		HTable table = null;
		try {
			table = new HTable(CONF, TABLE_NAME);
			Get get = new Get(Bytes.toBytes(rowKey));
			Result result = table.get(get);
			return generateEntity(result);
		} finally {
			if (table != null) {
				table.close();
			}
		}
	}

	public List<WebpageData> scan(String startRowKey, int pageSize)
			throws IOException {
		HTable table = null;
		try {
			PageFilter pageFilter = new PageFilter(pageSize);
			FilterList filterList = new FilterList(pageFilter);
			Scan scan = new Scan(Bytes.toBytes(startRowKey), filterList);
			table = new HTable(CONF, TABLE_NAME);
			List<WebpageData> entities = new ArrayList<WebpageData>(pageSize);
			ResultScanner rs = table.getScanner(scan);
			for (Result result = rs.next(); result != null; result = rs.next()) {
				WebpageData entity = generateEntity(result);
				if (entity == null) {
					continue;
				}
				entities.add(entity);
			}
			return entities;
		} finally {
			if (table != null) {
				table.close();
			}
		}
	}

	private WebpageData generateEntity(Result result) {
		byte[] key = result.getRow();
		NavigableMap<byte[], byte[]> p = result
				.getFamilyMap(Bytes.toBytes("p"));
		NavigableMap<byte[], byte[]> f = result
				.getFamilyMap(Bytes.toBytes("f"));
		NavigableMap<byte[], byte[]> s = result
				.getFamilyMap(Bytes.toBytes("s"));
		NavigableMap<byte[], byte[]> il = result.getFamilyMap(Bytes
				.toBytes("il"));
		NavigableMap<byte[], byte[]> ol = result.getFamilyMap(Bytes
				.toBytes("ol"));
		NavigableMap<byte[], byte[]> h = result
				.getFamilyMap(Bytes.toBytes("h"));
		NavigableMap<byte[], byte[]> mtdt = result.getFamilyMap(Bytes
				.toBytes("mtdt"));
		NavigableMap<byte[], byte[]> mk = result.getFamilyMap(Bytes
				.toBytes("mk"));
		if (p == null && f == null && s == null && il == null && ol == null
				&& h == null && mtdt == null && mk == null) {
			return null;
		}
		return new WebpageData(key, p, f, s, il, ol, h, mtdt, mk);
	}
}