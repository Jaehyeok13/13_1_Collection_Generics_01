package com.jh.example.list.run;

import com.jh.example.list.controller.ListController;

public class Run {

    public static void main(String[] args) {
	// 컬렉션 프레임 워크
	// 객체들을 효울적으로 추가, 삭제, 검색할 수 있도록 제공되는 컬렉션 라이브러리 interface를 통해
	// 정형화된 방법으로 다양한 컬렉션 클래스 이용
	// 컬렉션 제네릭(Generic)기법으로 구현됨
	// 컬랙션 List
	ListController lc = new ListController();
	lc.List();
    }

}
