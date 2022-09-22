/* 
 *  코드 작성자 : 공통
 *  코드 설명 : Action 인터페이스 생성을 통해 excute()함수 모든 Action에서 사용
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
 public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
