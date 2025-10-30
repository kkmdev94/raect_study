package org.example.egov.controller;

import org.example.egov.sevice.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

//@Controller
public class TestController {

    @Resource(name = "testService")
    private TestService testService;

    @RequestMapping("/test.do")
    public String showTestPage(Model model) {
        // 1. 서비스 클래스의 메서드 호출
        String messageFromService = testService.getEgovMessage();

        // 2. Model에 메시지를 담아서 View로 전달
        model.addAttribute("egovMessage", messageFromService);

        // 3. 기존 View 이름 (예: "testView")
        return "testView"; // -> /WEB-INF/views/testView.jsp
    }
}
