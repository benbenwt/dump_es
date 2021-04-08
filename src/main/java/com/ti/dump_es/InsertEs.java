package com.ti.dump_es;

import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.List;

public class InsertEs {
    public boolean uploadByDirectory(String stixDirectory,String esUrl) throws IOException {
        //去处id，得到字符串列表或map列表，提交
        ReadJson readStix=new ReadJson();
        InsertUtil insertUtil=new InsertUtil();
        EsUtil esUtil=new EsUtil();
        RestHighLevelClient client=esUtil.getClient(esUrl);

        List<String> strList=readStix.readStixDirectory(stixDirectory);
        for(String json_str:strList)
        {
            insertUtil.insertSample(json_str,client);
        }
        client.close();
        return true;
    }

    public static void main(String[] args) throws IOException {
        InsertEs insertEs=new InsertEs();
        insertEs.uploadByDirectory(args[0],args[1]);
    }
}
