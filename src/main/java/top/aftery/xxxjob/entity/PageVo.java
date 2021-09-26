package top.aftery.xxxjob.entity;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import lombok.Data;

import java.util.List;

/**
 * @author aftery
 * @Desc
 * @date 2021/9/24 15:25
 **/
@Data
@PageSelect(cssQuery = "body")
public   class  PageVo {

    @PageFieldSelect(cssQuery = ".article-box__title")
    private String title;

    @PageFieldSelect(cssQuery = "#mainScreen > div > div.blog-detail-container > div.detail-body-box > div:nth-child(2) > div.main-box > div > div.article-box.box-card.box-card--shadow > div > div.article-box__header > div.article-box__meta > div > div:nth-child(2) > a")
    private String item;

    @PageFieldSelect(cssQuery = "#mainScreen > div > div.blog-detail-container > div.detail-body-box > div:nth-child(2) > div.main-box > div > div.article-box.box-card.box-card--shadow > div > div.article-box__header > div.article-box__meta > div > div:nth-child(4)")
    private String date;

    @PageFieldSelect(cssQuery = "#mainScreen > div > div.blog-detail-container > div.detail-body-box > div:nth-child(2) > div.sidebar-box > div > div:nth-child(3) > div > div.section-body > div > div:nth-child(3) > div > div.user-item__avatar > a > div > img")
    private List<String> imgUlr;
    
}
