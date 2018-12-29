package com.yh.yhandmlu.daily;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class TestCsv {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
//        String url = "http://file.yzcdn.cn/upload_files/yz-file/2018/10/11/Fh7McIdznC_wYf5Aj_pmtATJloaU.csv";
        String url = "http://file-test.yzcdn.cn/upload_files/yz-test-file/2018/10/11/FsBsSAXV-_VjUOBZ6Jgx2gvh9fOX.csv";
        /*String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1539269154&di=435640aebc037c710e9b05ed34a17062&src=http://www.goumin.com/attachments/photo/0/0/69/17866/4573921.jpg";
        byte[] btImg = getImageFromNetByUrl(url);
        if (null != btImg && btImg.length > 0) {
            System.out.println("读取到：" + btImg.length + " 字节");
            String fileName = "person.jpg";
            writeImageToDisk(btImg, fileName);
        } else {
            System.out.println("没有从该连接获得内容");
        }*/
        System.out.println(pareUrlTxtInfo(url));

//        String csvSplitter = ";";
//        CsvPreference csvPreference = csvSplitter.equals(";")? CsvPreferences.SEMICOLON : CsvPreferences.COMMA;

        /*CsvPreference csvPreference = new CsvPreference.Builder('"', ';', "\r\n")
                        .useQuoteMode(new AlwaysQuoteMode())
                        .build();

        HttpUriRequest httpGet = getProxyMethod(url,false);
        System.out.println(JSON.toJSONString(httpGet));

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        InputStream inputStream = httpClient.execute(httpGet).getEntity().getContent();
        InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");

        ICsvListReader csvListReader = new CsvListReader(reader, csvPreference);
        System.out.println(JSON.toJSONString(csvListReader));*/
    }

    /**
     * 将图片写入到磁盘
     *
     * @param img      图片数据流
     * @param fileName 文件保存时的名称
     */
    public static void writeImageToDisk(byte[] img, String fileName) {
        try {
            File file = new File("/Users/yanghai/Downloads/testCsv" + fileName);
            FileOutputStream fops = new FileOutputStream(file);
            fops.write(img);
            fops.flush();
            fops.close();
            System.out.println("图片已经写入到本地");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据地址获得数据的字节流
     *
     * @param strUrl 网络连接地址
     * @return
     */
    public static byte[] getImageFromNetByUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从输入流中获取数据
     *
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }


    /**
     * 获取网络上文件流，读取文件内容
     * @param url http://file-test.yzcdn.cn/upload_files/yz-test-file/2018/10/11/FsBsSAXV-_VjUOBZ6Jgx2gvh9fOX.csv
     * @return
     */
    public static List<String> pareUrlTxtInfo(String url) {
        List<String> list = new ArrayList<String>();
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
//                String[] arr = line.split("\t");
                String[] arr = line.split(",");
                for (int i=0;i<arr.length;i++){
                    String s = arr[i];
                    System.out.println(i+"--"+s);
                }
                System.out.println("==========");
                list.add(line);
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public static HttpRequestBase getProxyMethod(String url, boolean isGet) {
        if(true) {
            int protocolEnd = url.indexOf("://");
            String protocol = url.substring(0, protocolEnd);
            String remainUrl = url.substring(protocolEnd + 3);
            int hostEnd = remainUrl.indexOf("/");
            String host = remainUrl.substring(0, hostEnd);
            String proxyUrl = "http://proxy-static.s.qima-inc.com" + remainUrl.substring(hostEnd);
            HttpRequestBase method = null;
            if (isGet) {
                method = new HttpGet(proxyUrl);
            }else {
                method = new HttpPost(proxyUrl);
            }
            method.setHeader("Host", host);
            if ("https".equalsIgnoreCase(protocol)) {
                method.setHeader("Scheme", "https");
            }else {
                method.setHeader("Scheme", "http");
            }
            return method;
        }else{
            if (isGet) {
                return new HttpGet(url);
            }else {
                return new HttpPost(url);
            }
        }
    }

}