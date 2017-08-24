package com.zserver.db;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZZZ on 2017/8/24.
 */
class BBB{
    public int a;
    public int b;
}
public class DBClientTest {
    @Test
    public void Test() {

        DBClient client = new DBClient();
        MongoClient mgclient = client.Connet();
        try {
            MongoDatabase db = mgclient.getDatabase("test");

            FindIterable<Document> doc = db.getCollection("TestTable").find();
            for (Document d : doc) {

                BBB a = DBClient.DocToBean(d, BBB.class);

                System.out.println(a.a);
            }

            MongoIterable<String> list = mgclient.listDatabaseNames();

            for (String name : list) {
                System.out.println(name);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}