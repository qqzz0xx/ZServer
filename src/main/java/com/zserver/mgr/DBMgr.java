package com.zserver.mgr;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.zserver.db.BagBase;
import com.zserver.db.DBClient;
import com.zserver.db.RoleBase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by ZZZ on 2017/8/25.
 */
public class DBMgr {
    private static String DBName = "test";
    private DBClient client;

    public void Init() {
        client = new DBClient();
        client.setUseDB(client.getClient().getDatabase(DBName));
    }

    public void Close() {
        client.Close();
    }

    public String FindPasswd(long userID) {
        FindIterable<Document> result = client.FindCollection("login").find(eq("userid", userID));
        if (result == null) return null;
        return (String) result.first().get("passwd");
    }

    public long FindRoleID(long userID) {
        FindIterable<Document> result = client.FindCollection("role").find(eq("userid", userID));
        if (result == null) return 0;
        return (long) result.first().get("roleid");
    }

    public BagBase FindBagBase(long roleid) {
        FindIterable<Document> result = client.FindCollection("bag").find(eq("roleid", roleid));
        if (result == null) return null;
        return DBClient.DocToBean(result.first(), BagBase.class);
    }

    public void InsertRole(RoleBase roleBase) {
        Gson gson = new Gson();
        Document doc = Document.parse(gson.toJson(roleBase));

        client.FindCollection("role").insertOne(doc);
    }

}
