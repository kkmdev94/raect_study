package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final이 붙은 필드객체를 파라미터로 받는 생성자를 바로 만들어 준다. ctrl + f12 를 이용하여 안에 있는 메서드 확인 가능
public class OrderServiceImplLombok implements OrderService{

    private final MemberRepository memberRepository; // 생성자 주입을 쓰면 final 키워드를 쓸수 있다.
    private final DiscountPolicy discountPolicy;
//    private final Object object; -> 이렇게 추가해도 생성자에서 추가를 안하고 @RequiredArgsConstructor 자동으로 만들어주므로 편하다.

//    @Autowired // -> 즉 아래의 코드에 있는 생성자가 지금처럼 주석 즉, 없어도 @RequiredArgsConstructor가 자동으로 만들어 준다는 것이다.
//    public OrderServiceImplLombok(MemberRepository memberRepository, DiscountPolicy discountPolicy) { // 가끔 생성자가 직접 필요할때만 만들어 쓰고 롬북을 통해 만들면 편하다.
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    // test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
