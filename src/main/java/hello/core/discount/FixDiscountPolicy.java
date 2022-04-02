package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int Price) {
        if (member.getGrade() == Grade.VIP) {  // enum 은 == 을 사용해도 된다.
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
