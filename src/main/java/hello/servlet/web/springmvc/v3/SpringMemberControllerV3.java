package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * @RequestParam으로 Map사용없이 바로 꺼내오기 가능. 기존에 age를 정수형으로 파싱해야했는데 그런 작업도 스프링이 자동으로 해줌
 * 그리고 method에 GET, POST 방식 지정가능.
 * 하지만 귀찮으니깐 @GetMapping을 사용하자.
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // GET인 경우에만 호출
    @GetMapping("/new-form")
    public String newForm() {
    return "new-form";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";




    }
}

