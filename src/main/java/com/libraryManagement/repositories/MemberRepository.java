package com.libraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
