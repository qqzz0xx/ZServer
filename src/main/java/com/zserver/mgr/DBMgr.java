package com.zserver.mgr;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.zserver.db.BagBase;
import com.zserver.db.DBClient;
import com.zserver.db.RedisClient;
import com.zserver.db.RoleBase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by ZZZ on 2017/8/25.
 */
public class DBMgr {
    private static String DBName = "test";
    private DBClient client = new DBClient();
    private RedisClient redisClient = new RedisClient();

    public void Init() {
        client.Connet();
        redisClient.Connet();
        client.setUseDB(client.getClient().getDatabase(DBName));
    }

    public void Close() {
        client.Close();
        redisClient.Close();
    }

    public String FindPasswd(long userID) {
        return  FindField(userID, "userid", "login", "passwd");
    }

    public String FindRoleID(long userID) {
        return  FindField(userID, "userid","role",  "roleid");
    }

    public BagBase FindBagBase(long roleid) {
        return FindTable(roleid, "roleid", "bag", BagBase.class);
    }

    public void InsertRole(RoleBase roleBase) {
        Gson gson = new Gson();
        Document doc = Document.parse(gson.toJson(roleBase));

        client.FindCollection("role").insertOne(doc);
    }

    private String FindField(Object key, String keyName, String table, String field){
        String redisKey = table+"@"+key+field;
        String redisVal = redisClient.Get(redisKey);
        if (redisVal != null) return redisVal;
        FindIterable<Document> result = client.FindCollection(table).find(eq(keyName, key));
        if (result == null) return null;
        redisVal = (String) result.first().get(field);
        redisClient.Set(redisKey, redisVal);

        return redisVal;
    }

    private <T> T FindTable(Object key,  String keyName, String table, Class<T> tClass){
        String redisKey = table+"@"+key;
        String redisVal = redisClient.Get(redisKey);
        Document doc = null;
        if (redisVal != null) {
            doc = Document.parse(redisVal);
            return DBClient.DocToBean(doc, tClass);
        }

        FindIterable<Document> result = client.FindCollection(table).find(eq(keyName, key));
        if (result == null) return null;
        redisVal = result.first().toJson();
        redisClient.Set(redisKey, redisVal);

        return DBClient.DocToBean(result.first(), tClass);
    }

}
