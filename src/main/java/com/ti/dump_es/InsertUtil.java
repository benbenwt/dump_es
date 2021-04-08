package com.ti.dump_es;


import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;


public class InsertUtil {
    EsUtil esUtil=new EsUtil();
    RestHighLevelClient client;
    public boolean insertSample(String jsonStr,RestHighLevelClient client) throws IOException {
        IndexRequest request=new IndexRequest("myindex");
        request.source(jsonStr, XContentType.JSON);
        IndexResponse indexResponse=client.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
        return true;
    }
}
