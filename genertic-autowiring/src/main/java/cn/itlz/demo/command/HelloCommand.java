package cn.itlz.demo.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/2 0002
 */
public class HelloCommand extends HystrixCommand<String> {
    private HttpClient httpClient;
    private String url ;
    protected HelloCommand(String url) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleKey"));
        this.url = url;
        this.httpClient = HttpClients.createDefault();
    }

    @Override
    protected String run() throws Exception {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        return EntityUtils.toString(response.getEntity());
    }

    @Override
    protected String getFallback() {
        return "执行Hystrix回退方法";
    }

    public static void main(String[] args) {
        HelloCommand helloCommand = new HelloCommand("http://localhost:8080/normalReq");
        String result = helloCommand.execute();
        System.out.println(result);
        System.out.println("----------------------------");
        HelloCommand helloCommand1 = new HelloCommand("http://localhost:8080/errorReq");
        String result1 = helloCommand1.execute();
        System.out.println(result1);

    }
}
