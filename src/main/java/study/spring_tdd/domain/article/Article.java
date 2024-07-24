package study.spring_tdd.domain.article;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Article {

    private Long id;
    private String title;
    private String content;

}
