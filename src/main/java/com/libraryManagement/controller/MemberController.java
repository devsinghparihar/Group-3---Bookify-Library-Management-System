package com.libraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagement.entities.Book;
import com.libraryManagement.entities.Member;
import com.libraryManagement.repositories.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {
@Autowired
	private MemberRepository memberRepository;

@PostMapping("/create-member")
public ResponseEntity<Member> createMember(@RequestBody Member member)
{
	Member members=memberRepository.save(member);
	return new ResponseEntity<Member>(members,HttpStatus.CREATED);
}
@GetMapping("/member-list")
// @RequestMapping(value="create-student",method="POST")
public List<Member> getAllMembers() {
	return (List<Member>) memberRepository.findAll();
}
@GetMapping("/member-list/{memberId}")
public ResponseEntity<Member> getMemberById(@PathVariable long memberId){
	
	Member member = memberRepository.findById(memberId).get();
	return new ResponseEntity<Member>(member,HttpStatus.OK);
	
}
@PutMapping("/update-member")
public Member updateMember(@RequestBody Member obj) {
	return memberRepository.save(obj);
}

@DeleteMapping("/delete-member/{memberId}")
public ResponseEntity<Member> deleteMember(@PathVariable long memberId) {

		memberRepository.deleteById(memberId);
	 return new ResponseEntity<Member>(HttpStatus.OK);
}

}
