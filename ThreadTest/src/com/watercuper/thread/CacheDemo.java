package com.watercuper.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
	
	private Map< String, Object> cache=new HashMap<String,Object>();
	public static void main(String[] args) {
		
	}
	
	private ReadWriteLock rwl=new ReentrantReadWriteLock();
	public /*synchronized*/ Object getData(String key) {
		
		rwl.readLock().lock();
		Object object=null;
		try {
			object=cache.get(key);
			if(object==null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if(object==null) {
						object="aaaa";  //去查询数据库
					}
				} finally {
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} finally {
			rwl.readLock().unlock();
		}
		return object;
	}
}
