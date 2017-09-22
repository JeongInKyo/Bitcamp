/* .class 파일 분리하기
 - .class 파일을 관리하기 쉽도록 별도의 폴더로 분리하는 방법을 알아보자.
 - 왜 .class 파일을 소스 파일로부터 분리하는가?
*/

/* 분리
 > javac -d [.class 파일을 저장할 폴더] [소스파일명]
 > md bin
 > javac -d bin Test03.java

클래스 파일을 분리하는 이유?
 - 소스 파일과 클래스 파일을 분리함으로써
   소스 파일을 관리하기 쉽고,
   배포를 위해 클래스 파일을 추출하기도 쉽다.

다른 폴더에 있는 클래스 실행하기
> java -classpath [.class 파일이 있는 폴더] 클래스명
> java -cp [.class 파일이 있는 폴더] 클래스명
예)
> java -classpath bin Test03(클래스명)
> java -cp bin Test03(클래스명)
C드라이브에서 실행할 때 > java -cp c:\workspace\java-basic\bin Test03

운영체제에 .class 파일이 있는 폴더를 등록해두면
매번 .class 파일을 실행할 때 마다 매번 -cp 또는 -classpath를
사용하여 .class 파일이 있는 경로를 지정할 필요가 없다. 명령창에서 환경변수 등록할때(주의할점 : 재부팅하면 지워짐)
> set CLASSPATH=[클래스파일이 있는 폴더]
예)
> set CLASSPATH=c:\workspace\java-basic\bin
> java Test03

영,수 EBS 듣기(구글 알고리즘을 위해)
수학을 배울때 증명을 하려 하지마라.
답보다는 공식이 어디에 쓰이는지를 생각하라.(이유 : 답은 컴퓨터가 계산해주기 때문.)

리눅스(linux)는 환경변수 설정하는 방법이 다르다.


*/

class Test03 {
  public static void main(String[] args) {
    System.out.println("안녕하세요!");
  }
}