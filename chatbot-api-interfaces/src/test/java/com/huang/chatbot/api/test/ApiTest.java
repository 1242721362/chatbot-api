package com.huang.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        //封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie","zsxq_access_token=1609AA25-B0DD-91D3-00C6-1B0D9848D2F0_36CC95B9027B7415; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415821458128848%22%2C%22first_id%22%3A%2218df9b77be1a8f-06f05686fcfadf8-4c657b58-1638720-18df9b77be2c48%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZjliNzdiZTFhOGYtMDZmMDU2ODZmY2ZhZGY4LTRjNjU3YjU4LTE2Mzg3MjAtMThkZjliNzdiZTJjNDgiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU4MjE0NTgxMjg4NDgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415821458128848%22%7D%2C%22%24device_id%22%3A%2218df9b77be1a8f-06f05686fcfadf8-4c657b58-1638720-18df9b77be2c48%22%7D; zsxqsessionid=4ad97f49d909461d7f50ec19e4f6aee6; abtest_env=product" );
        get.addHeader("Content-Type","application/json, text/plain, */*");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }


    }
    @Test
    public void answer() throws  IOException{
        //封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8855824848582222/comments");

        post.addHeader("cookie","zsxq_access_token=1609AA25-B0DD-91D3-00C6-1B0D9848D2F0_36CC95B9027B7415; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415821458128848%22%2C%22first_id%22%3A%2218df9b77be1a8f-06f05686fcfadf8-4c657b58-1638720-18df9b77be2c48%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZjliNzdiZTFhOGYtMDZmMDU2ODZmY2ZhZGY4LTRjNjU3YjU4LTE2Mzg3MjAtMThkZjliNzdiZTJjNDgiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU4MjE0NTgxMjg4NDgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415821458128848%22%7D%2C%22%24device_id%22%3A%2218df9b77be1a8f-06f05686fcfadf8-4c657b58-1638720-18df9b77be2c48%22%7D; zsxqsessionid=4ad97f49d909461d7f50ec19e4f6aee6; abtest_env=product" );
        post.addHeader("Content-Type","application/json, text/plain, */*");
        //回答数据
        String paramJson ="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我也不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
//封装入参信息
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
//执行信息
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }


    }
}
