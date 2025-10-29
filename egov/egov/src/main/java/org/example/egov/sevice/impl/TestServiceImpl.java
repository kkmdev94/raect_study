package org.example.egov.sevice.impl;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.example.egov.sevice.TestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl extends EgovAbstractServiceImpl implements TestService {

    @Override
    public String getEgovMessage() {
        egovLogger.info("eGov 서비스 레이어 및 로거 테스트 성공");

        return "eGovFramework Service Layer is Working!";
    }
}
