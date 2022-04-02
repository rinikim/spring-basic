package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * orderService 입장에서는 할인에 대한 부분을 전혀 신경쓰지 않고, discountPolicy 에 할인에 대한 부분을 위임하고 있다.
 * 할인에 대한 부분은 discountPolicy 에서 결과만 던져주기 때문에 단일책임원칙(SRP) 잘 지켜지고 있다.
 * 추후에 할인에 대한 변경이 필요하다면, 할인쪽만 변경하면 되기 때문이다.
 * 만약 할인에 대한 부분이 discountPolicy 가 없다면, 할인과 같은 변경이 들어왔을 때 orderService 를 고쳐야 하는 일이 생긴다.
 */
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
