package top.aftery.xxxjob;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.XmlWebServiceClient;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.aftery.xxxjob.entity.PageVo;

/**
 * @author aftery
 */
@SpringBootApplication
public class XxxJobApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(XxxJobApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://my.oschina.net/xuxueli/blog")
                .setWhiteUrlRegexs("https://my\\.oschina\\.net/xuxueli/blog/\\d+")
                .setThreadCount(3)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36")
                .setPageParser(new PageParser<PageVo>() {
                    @Override
                    public void parse(Document document, Element element, PageVo o) {
                        System.out.println("document.baseUri() = " + document.baseUri());
                        System.out.println("o = " + o.toString());
                    }
                })
                .build();
        crawler.start(true);
    }
}
