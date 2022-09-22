package com.honda.ws.soap.client.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.honda.ws.soap.client.config.ResourceLoader;
import com.honda.ws.soap.client.config.ServiceConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author Vinisha Pathak
 *
 */
public class ServiceResponseCacheUtil {

	private static LoadingCache<String, String> cache = null;
	private static int SERVICE_RESPONSE_CACHE_EXPIRY_TIME = Integer.parseInt(ResourceLoader.getKeyValue(ServiceConfig.SERVICE_RESPONSE_CACHE_EXPIRY_TIME));
	private static int SERVICE_RESPONSE_CACHE_MAX_SIZE = Integer.parseInt(ResourceLoader.getKeyValue(ServiceConfig.SERVICE_RESPONSE_CACHE_MAX_SIZE));

	static {
		try {
			cache = (LoadingCache<String, String>) CacheBuilder.newBuilder()
					.expireAfterWrite(SERVICE_RESPONSE_CACHE_EXPIRY_TIME, TimeUnit.SECONDS)
					.maximumSize(SERVICE_RESPONSE_CACHE_MAX_SIZE).build(new CacheLoader<String, String>() {
						@Override
						public String load(String arg0) throws Exception {
							return null;
						}
					});

		} catch (Exception e) {
		}
	}

	/**
	 * return value of key from the cache
	 * 
	 * @param key
	 * @return
	 */
	public static String getKeyValue(String key) {

		String keyValue = null;
		try {
			keyValue = cache.get(key);
		} catch (Exception e) {
		}
		return keyValue;
	}

	/**
	 * set element in the cache
	 * 
	 * @param key
	 * @param value
	 */
	public static void setKeyValue(String key, String value) {
		try {
			if (getKeyValue(key) == null) {
				cache.put(key, value);
			}
		} catch (Exception e) {
		}
	}
}
