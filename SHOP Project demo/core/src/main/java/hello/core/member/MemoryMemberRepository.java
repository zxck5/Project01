package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{
    private Map<Long,Member> store = new HashMap<>();
//    private static Long

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findbyId(Long id) {
        return store.get(id);
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
