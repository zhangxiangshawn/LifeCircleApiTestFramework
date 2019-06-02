package com.shawn.api.test.media;

import com.shawn.api.validation.ResponseChecker;
import com.shawn.apitest02.HttpRequest;
import org.apache.http.HttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMedia {
    private String baseUrl = "https://life-circle-prd.xinchao.com/life";

    @Test
    public void testGetMediaList() throws IOException {
        String url = baseUrl + "/media/list";
        Map<String, Object> header = new HashMap<String, Object>();
        header.put("Content-Type","application/json");
        header.put("token", "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NjMwODMyMTUsInVzZXJuYW1lIjoiMTBmYmU3YjAtNDE4OS00ZTk1LWFkZWUtZTM5Y2U0NjQzYjExIn0.G2QyJey-5AhN8sgt7zsnAcS4SKP9RSbVp9yfQqVwRKnIdP27gZLoUOZUIMissIciO7B6nc7eX7jFY8-X2e5yAA");
        HttpResponse response = new HttpRequest(url)
                .setHeaders(header)
                .setContent("{ \"pageVo\": { \"pageIndex\":1, \"pageSize\": 10 }, \"screenType\": 3}")
                .doPost();
        Map<String, Object> exceptMap = new HashMap<String,Object>();

        exceptMap.put("status.message", "成功");

        ResponseChecker responseChecker = new ResponseChecker(response);
        responseChecker.codeCheck(200);
        responseChecker.dataCheck(exceptMap);
    }

    @Test
    public void testMediaCreativeUpload() throws IOException {
        String url = baseUrl + "/media/creativeUpload";
        Map<String, Object> header = new HashMap<String, Object>();
        header.put("Content-Type","application/json");
        header.put("token", "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NjMwODMyMTUsInVzZXJuYW1lIjoiMTBmYmU3YjAtNDE4OS00ZTk1LWFkZWUtZTM5Y2U0NjQzYjExIn0.G2QyJey-5AhN8sgt7zsnAcS4SKP9RSbVp9yfQqVwRKnIdP27gZLoUOZUIMissIciO7B6nc7eX7jFY8-X2e5yAA");
        HttpResponse response = new HttpRequest(url)
                .setHeaders(header)
                .setContent("{ \"fileInfo\":  \"screenType\": 2}")
                .doPost();
        Map<String, Object> exceptMap = new HashMap<String,Object>();

        exceptMap.put("status.message", "成功");

        ResponseChecker responseChecker = new ResponseChecker(response);
        responseChecker.codeCheck(200);
        responseChecker.dataCheck(exceptMap);
    }

    @Test
    public void testPremiseStatistic() throws IOException {
        String url = baseUrl + "/premise/bdstatistic/863944";
        HttpResponse response = new HttpRequest(url).doGet();

        Map<String, Object> exceptMap = new HashMap<String,Object>();

        exceptMap.put("status.message", "成功");

        ResponseChecker responseChecker = new ResponseChecker(response);
        responseChecker.codeCheck(200);
        responseChecker.dataCheck(exceptMap);
        System.out.println(response.getEntity().getContent());
    }

    @Test
    public void testPremiseGetfilter() throws IOException {
        String url = baseUrl + "/premise/getfilter/12";
        HttpResponse response = new HttpRequest(url).doGet();

        Map<String, Object> exceptMap = new HashMap<String,Object>();

        exceptMap.put("status.message", "成功");

        ResponseChecker responseChecker = new ResponseChecker(response);
        responseChecker.codeCheck(200);
        responseChecker.dataCheck(exceptMap);
        System.out.println(response.getEntity().getContent());
    }
}
