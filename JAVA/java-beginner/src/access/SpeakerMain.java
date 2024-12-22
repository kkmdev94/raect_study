package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);
        speaker.showVloulme();

        speaker.volumeUp();
        speaker.showVloulme();

        speaker.volumeUp();
        speaker.showVloulme();

        //필드에 직접 접근
        System.out.println("volume 필드 직접 접근 수정");
//        speaker.volume = 200;
        speaker.showVloulme();
    }
}
/*
접근 제어자의 종류
private : 개인적인, 해당 클래스를 제외하고 외부에서는 접근을 할 수 없다.(모든 접근을 막는다.)
default(package-private): 같은 패키지 안에서만 호출은 허용한다.
protected : 같은 패키지 안에서 호출은 허용, 단 패키지가 달라도 상속 관계의 호출은 허용한다.
public : 모든 외부 호출을 허용한다.

순서대로 private이 가장 많이 차단하고 public이 가장 많이 허용한다.
private -> default -> protected -> public / 기본값은 default이다.

접근 제어자는 필드와 메서드, 생성자에 사용, 추가로 클래스 레벨에서도 일부 접근 제어자 사용 가능 -> 이부분은 뒤에서 설명.
지역 변수에는 사용할 수 없다.


 */