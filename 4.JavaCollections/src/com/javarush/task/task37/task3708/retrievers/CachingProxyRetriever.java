package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private LRUCache<Long, Object> lruCache; //= new LRUCache<>(16);
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = lruCache.find(id);
        if (obj != null) return obj;
        else {
            obj = originalRetriever.retrieve(id);
            lruCache.set(id, obj);
            return obj;
        }
    }
}
