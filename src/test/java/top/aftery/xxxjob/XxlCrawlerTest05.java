package top.aftery.xxxjob;

import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.conf.XxlCrawlerConf;
import com.xuxueli.crawler.model.PageRequest;
import com.xuxueli.crawler.parser.PageParser;
import com.xuxueli.crawler.util.JsoupUtil;
import com.xuxueli.crawler.util.ProxyIpUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import top.aftery.xxxjob.utils.HttpUtils;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aftery
 * @Desc
 * @date 2021/9/24 16:12
 **/
@Slf4j
public class XxlCrawlerTest05 {


    @PageSelect(cssQuery = "#list > table > tbody > tr")
    public static class PageVo {

        @PageFieldSelect(cssQuery = "td:eq(0)", selectType = XxlCrawlerConf.SelectType.TEXT)
        private String ip;

        @PageFieldSelect(cssQuery = "td:eq(1)", selectType = XxlCrawlerConf.SelectType.TEXT)
        private int port;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return "PageVo{" +
                    "ip='" + ip + '\'' +
                    ", port=" + port +
                    '}';
        }
    }

    public static void main(String[] args) {

        // 代理池
        final List<PageVo> proxyPool = new ArrayList<PageVo>();

        // 构造爬虫
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://www.kuaidaili.com/free/inha/1")
                .setWhiteUrlRegexs("https://www.kuaidaili.com/free/inha/\\b[1-5]")      // 前2页数据
                //.setWhiteUrlRegexs(new HashSet<String>(Arrays.asList("https://www.kuaidaili.com/free/inha/\\\\d+/")))      // 全部数据
                //.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Safari/537.36 Edg/93.0.961.52")
//                .setThreadCount(1)
                .setUserAgent(HttpUtils.getAgent())
                .setPageParser(new PageParser<PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, PageVo pageVo) {
                        if (pageVo.getPort() == 0) {
                            return;
                        }
                        if (200 == HttpUtils.checkProxy(pageVo.getIp(), pageVo.getPort())) {
                            proxyPool.add(pageVo);
                            log.info("proxy pool size : {}, new proxy: {}", proxyPool.size(), pageVo);
                        }

                    }
                })
                .build();

        // 启动
        crawler.start(true);

        // 代理池数据
        log.info("----------- proxy pool total size : {} -----------", proxyPool.size());
        log.info(proxyPool.toString());

        // 校验代理池    (代理方式请求IP地址查询网IP138，可从页面响应确认代理是否生效)
        log.info("----------- proxy pool check -----------");
        if (proxyPool != null && proxyPool.size() > 0) {
            for (PageVo pageVo : proxyPool) {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }


}