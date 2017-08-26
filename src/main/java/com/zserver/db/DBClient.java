package com.zserver.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.lang.reflect.Field;

/**
 * Created by ZZZ on 2017/8/24.
 */
public class DBClient {

    public MongoClient Connet() {
        client = new MongoClient(dburl);
        return  client;
    }
    public void Close() {
        client.close();
    }

    public MongoDatabase getUseDB() {
        return useDB;
    }

    public void setUseDB(MongoDatabase useDB) {
        this.useDB = useDB;
    }

    public void UseDatabase(String name)
    {
        useDB = client.getDatabase(name);
    }

    public MongoCollection<Document> FindCollection(String name) {
        return useDB.getCollection(name);
    }

    public MongoClientURI getDburl() {
        return dburl;
    }

    public void setDburl(MongoClientURI dburl) {
        this.dburl = dburl;
    }

    public MongoClient getClient() {

        return client;
    }

    MongoClient client;
    MongoDatabase useDB;

    MongoClientURI dburl = new MongoClientURI("mongodb://zzz:123001@cluster0-shard-00-00-8r7cu.mongodb.net:27017," +
            "cluster0-shard-00-01-8r7cu.mongodb.net:27017," +
            "cluster0-shard-00-02-8r7cu.mongodb.net:27017/<DATABASE>?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");

    public static <T> T DocToBean(Document doc, Class<T> tClass) {

        try {
            T o = tClass.newInstance();
            Field[] fields = tClass.getDeclaredFields();
            for(Field field : fields) {

                String fieldName = field.getName();
                Object val = doc.get(fieldName);
                if (val == null) continue;
                if (val instanceof Document){
                    val = DocToBean((Document) val, field.getClass());
                }

                field.set(o, val);
                
            }

            return o;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }

}
