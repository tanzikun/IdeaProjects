package Observer.news;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Article article = (Article) arg;
        System.out.println("发表了新文章,标题:"+ article.getArticleTitle()+",内容:"+article.getArticleContent());
    }
}
