package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        // 기본값은 디폴트, 지정을 하지 않고 기본으로 하면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작위치가 되어서 다 뒤진다.
        // 권장 방법은 : 패키지 위치를 지정하지 않고 설정 정보 클래스의 위치를 프로젝트 최상단에 두는것이다.
        basePackages = "hello.core", // 해당 패키지부터 찾아간다. / 이 베이스패키지를 사용하는 이유는 모든 패키지(라이브러리 포함) 다 뒤져서 시간이 오래걸리기 때문이다.
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))

public class AutoAppConfig { // 설정이 없어지는 대신 각 기능에 Component를 이용해 스프링 빈에 등록하고 의존과계 주입을 위한 Autowirte를 사용한다.

//    // 수동 빈.
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
    /*
     수동 빈 등록시 남는 로그 : 수동 빈 등록이 우선권을 가진다.(수동 빈이 자동빈을 오버라이딩 해버린다.)
    Overriding bean definition for bean 'memoryMemberRepository' with a different definition: replacing
    [Generic bean: class=hello.core.member.MemoryMemberRepository; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0;
    autowireCandidate=true; primary=false; fallback=false; factoryBeanName=null; factoryMethodName=null; initMethodNames=null; destroyMethodNames=null;
    defined in file [D:\study\Spring2\out\production\classes\hello\core\member\MemoryMemberRepository.class]] with [Root bean: class=null; scope=; abstract=false;
    lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; fallback=false; factoryBeanName=autoAppConfig;
    factoryMethodName=memberRepository; initMethodNames=null; destroyMethodNames=[(inferred)]; defined in hello.core.AutoAppConfig]

    단 의도적으로 기대했다면 상관이 없다, 하지만 현실은 개발자가 의도적으로 한다기보단 여러 설정들이 꼬여서 이런 결과가 만들어지는 경우가 대부분이다.
    그러면은 정말 잡기 어려운 버그가 만들어진다. 항상 잡기 어려운 버그는 애매한 버그다.
    그래서 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하게 변경되었다.
     */
}
