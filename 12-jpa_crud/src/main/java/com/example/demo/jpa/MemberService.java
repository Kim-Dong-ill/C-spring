package com.example.demo.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepositoey mRepo;
	
	//저장
	public Member insert(Member member) {
		Member returnMember = mRepo.save(member);
		return returnMember;
	}

	//리스트 보기
	public List<Member> selectAll(){
		List<Member> list = mRepo.findAll();
		return list;
	}
	
	//단일 항목 보기
	public Optional<Member> select(Long id){
		Optional<Member> member = mRepo.findById(id);
		return member;
	}
	
	//삭제
	public void delete(Long id) {
		mRepo.deleteById(id);
	}
	
	//업데이트
	public Member update(Member member) {
		Member returnMember = mRepo.save(member);
		return returnMember;
	}
}
