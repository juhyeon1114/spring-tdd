package study.spring_tdd.domain.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;
import study.extensions.MysqlContainerExtension;
import study.extensions.RabbitContainerExtension;
import study.extensions.RedisContainerExtension;

//@Testcontainers
//@ExtendWith(SpringExtension.class)
@SpringBootTest
@ExtendWith({MysqlContainerExtension.class, RedisContainerExtension.class, RabbitContainerExtension.class})
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void 생성과_조회() throws Exception {
        // given
        Post post = postRepository.save(Post.create("제목", "내용"));
        Long savedId = post.getId();

        // when
        Optional<Post> optionalPost = postRepository.findById(savedId);

        // then
        Post foundPost = optionalPost.orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        assertThat(foundPost.getTitle()).isEqualTo("제목");
        assertThat(foundPost.getContent()).isEqualTo("내용");
    }

}