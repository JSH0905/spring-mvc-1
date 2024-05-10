package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


/** JUnit5부터는 테스트 클래스 생성시 public 생략 가능 */
class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach // 테스트 종료시 초기화
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Member member1 = new Member("JSH0905", 25);

        // when
        Member savedMember = memberRepository.save(member1);

        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        // given
        Member member1 = new Member("JSH0905", 25);
        Member member2 = new Member("Kim", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
        }


}