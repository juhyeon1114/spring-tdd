package study.spring_tdd.parameterized;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.spring_tdd.domain.article.Article;
import study.spring_tdd.domain.article.ArticleType;

@Slf4j
class SampleParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 숫자_테스트(int num) {
        log.info("{} 테스트 코드", num);
    }

    @ParameterizedTest(name = "{index}번째 테스트 {0}")
    @EnumSource(ArticleType.class)
    void Enum_테스트(ArticleType articleType) {
        log.info("{} 테스트 코드", articleType);
    }

    @ParameterizedTest
    @CsvSource(value = {"a1,a2,a3,a4", "b1,b2,b3,b4", "c1,c2,c3,c4"}, delimiter = ',')
    void CSV_테스트(String v1, String v2, String v3, String v4) {
        log.info("{}, {}, {}, {} 테스트 코드", v1, v2, v3, v4);
    }

    @ParameterizedTest
    @MethodSource("study.spring_tdd.domain.article.DummyArticles#getDummyArticles")
    void Method_테스트(Article article) {
        log.info("{} 테스트 코드", article.getId());
    }

    // @NullSource
    // @EmptySource
    // @NullAndEmptySource

    // @CsvFileSource

    // @ArgumentsSource

}