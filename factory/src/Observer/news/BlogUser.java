package Observer.news;

import java.util.Observable;

public class BlogUser extends Observable {

    public void publishBlog(String articleTitle, String articleContent){
        System.out.println("博主发表新文章，标题:"+articleTitle+",内容:"+articleContent);
        Article article = new Article();
        article.setArticleContent(articleContent);
        article.setArticleTitle(articleTitle);
        this.setChanged();
        this.notifyObservers(article);
    }


}
