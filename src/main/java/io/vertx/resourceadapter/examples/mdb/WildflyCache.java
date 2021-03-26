package io.vertx.resourceadapter.examples.mdb;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.Logger;

import life.genny.eventbus.WildflyCacheInterface;

//@ApplicationScoped
public class WildflyCache implements WildflyCacheInterface {

	/**
	 * Stores logger object.
	 */
	protected static final Logger log = org.apache.logging.log4j.LogManager
			.getLogger(MethodHandles.lookup().lookupClass().getCanonicalName());


//	public WildflyCache(Hazel inDb) {
//		this.inDb = inDb;
//	}

	public WildflyCache()
	{
		
	}
	
	@Override
	public Object readCache(String realm, String key, String token) {

		Object ret = null;//inDb.getMapBaseEntitys(realm).get(key);

		return ret;
	}

	@Override
	public void writeCache(String realm, String key, String value, String token, long ttl_seconds) {
		synchronized (this) {
		if (value == null) {
			//inDb.getMapBaseEntitys(realm).remove(key);
		} else {
			//inDb.getMapBaseEntitys(realm).put(key, value);
		}
		}

	}

	@Override
	public void clear(String realm) {
		//inDb.getMapBaseEntitys(realm).clear();

	}

}
