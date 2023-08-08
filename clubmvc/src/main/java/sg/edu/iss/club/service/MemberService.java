package sg.edu.iss.club.service;

import java.util.List;

import sg.edu.iss.club.domain.Member;

public interface MemberService {
  public boolean saveMember(Member member);

  public List<Member> findAllMembers();

  public Member findMemberById(Integer id);

  public void deleteMember(Member member);

  public List<String> findAllMemberNames();

  public Member findMemberByFirstName(String firstName);
}
