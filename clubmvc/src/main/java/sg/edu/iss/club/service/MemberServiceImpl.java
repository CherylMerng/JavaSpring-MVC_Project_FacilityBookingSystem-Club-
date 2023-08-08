package sg.edu.iss.club.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.repo.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberRepository memberRepository;

  @Transactional
  public boolean saveMember(Member member) {
    if (memberRepository.save(member) != null)
      return true;
    else
      return false;
  }

  @Transactional
  public List<Member> findAllMembers() {
    return memberRepository.findAll();
  }

  @Transactional
  public Member findMemberById(Integer id) {
    return memberRepository.findById(id).get();
  }

  @Transactional
  public void deleteMember(Member member) {
    memberRepository.delete(member);
  }

  @Transactional
  public List<String> findAllMemberNames() {
    List<Member> members = memberRepository.findAll();
    
    List<String> names = new ArrayList<String>();
    for (Member member : members) {
      names.add(member.getFirstName());
    }
    
    return names;
  }

  @Transactional
  public Member findMemberByFirstName(String firstName) {
    return memberRepository.findMemberByFirstName(firstName.trim()).get(0);
  }
}
