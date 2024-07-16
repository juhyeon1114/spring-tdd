package study.spring_tdd.domain.post.mock;

import java.time.LocalDateTime;
import java.util.stream.Stream;
import study.spring_tdd.domain.post.model.Post;

public class DummyPosts {

    public static Stream<Post> getDummyPosts() {
        return Stream.of(
            new Post(1L, "제목1", "내용1", LocalDateTime.now()),
            new Post(2L, "제목2", "내용2", LocalDateTime.now()),
            new Post(3L, "제목3", "내용3", LocalDateTime.now()),
            new Post(4L, "제목4", "내용4", LocalDateTime.now()),
            new Post(5L, "제목5", "내용5", LocalDateTime.now())
        );
    }

}
