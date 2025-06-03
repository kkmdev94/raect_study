package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServeltV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServeltV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>(); // 맵핑 정보를 호출하기 위한 hashMap, String에는 url이 들어오고 해당 url이 키가 되어 관련된 Controller를 호출.

    public FrontControllerServeltV3() { // 그 url호출을 위한 생성자, 즉 생성자를 통해서 url이 오면 해당 컨트롤러를 호출
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap을 넘겨야 된다.
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        // 논리이름인 new-form을 물리이름으로 변환
        String viewName = mv.getViewName();// 여기까지는 논리 이름인 new-form, save 등 그냥 논리적인 이름만 불러온다.

        MyView view = viewResolver(viewName); // 앞의 경로와 viewName에 들어온 논리 이름을 합쳐서 새로운 인스턴스 생성 후 view에 담기 / 해당 인스턴스를 메서드로 전환.
        view.render(mv.getModel(), request, response); // 그걸 토대로 view를 render 한다.
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
