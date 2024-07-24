package study.spring_tdd.domain.article;

import java.util.stream.Stream;

public class DummyArticles {

    public static Stream<Article> getDummyArticles() {
        return Stream.of(
                new Article(1L, "제목1", "내용1"),
                new Article(2L, "제목2", "내용2"),
                new Article(3L, "제목3", "내용3"),
                new Article(4L, "제목4", "내용4"),
                new Article(5L, "제목5", "내용5")
        );
    }

}
