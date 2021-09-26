package top.aftery.xxxjob;

import cn.hutool.http.HttpUtil;
import com.sun.deploy.net.HttpUtils;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.conf.XxlCrawlerConf;
import com.xuxueli.crawler.model.PageRequest;
import com.xuxueli.crawler.parser.PageParser;
import com.xuxueli.crawler.proxy.ProxyMaker;
import com.xuxueli.crawler.proxy.strategy.RoundProxyMaker;
import com.xuxueli.crawler.util.JsoupUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.HeaderUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetSocketAddress;
import java.net.Proxy;
@Slf4j
@SpringBootTest
class XxxJobApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String s = HttpUtil.get("https://www.kuaidaili.com/free/inha/");
        System.out.println(s);
    }
}
