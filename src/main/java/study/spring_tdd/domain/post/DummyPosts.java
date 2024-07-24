package study.spring_tdd.domain.post;

import java.util.stream.Stream;

public class DummyPosts {

    public static Stream<Post> getDummyPosts() {
        return Stream.of(
                Post.create("제목1", "내용1"),
                Post.create("제목2", "내용2"),
                Post.create("제목3", "내용3"),
                Post.create("제목4", "내용4"),
                Post.create("제목5", "내용5")
        );
    }

}
