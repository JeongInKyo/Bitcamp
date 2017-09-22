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

/* 소스 파일 분리하기
- 소스 파일을 관리하기 쉽도록 별도의 폴더로 분리하는 방법을 알아보자!
- 왜 소스 파일을 별도의 폴더로 분리하는가?
  소스 파일을 보다 쉽게 관리하기 위함.

예)
현재위치 $프로젝트 > javac -d [.class 파일을 저장할 폴더] [폴더명/.../소스파일명]
현재위치 $프로젝트 > md src

현재위치 $프로젝트 > javac -d bin src/Test04.java
                  > javac -d bin encoding utf8 src/Test04.java

스프링 프레임워크
github에 저장할때 제목의 가운데 _언더바 사용.
소스파일과 bin파일은 나눠서 저장.
마이크로 칼리지(초 단과 대학-초 전문성을 위한. 한국은 10년뒤에?)
edx(대학강의 무료로 보는곳-하버드,MIT,스탠포드)

소스코드II
- Maven 프로젝트의 디렉토리 구조를 알아보자!
- 왜 Maven 프로젝트의 디렉토리 구조를 사용하는가?

*/

/* Maven 프로젝트 디렉토리 구조
   $프로젝트폴더
    /src
      /main
        /java       <= 자바 소스 파일을 두는 폴더
        /resources  <= 프로그램 설정 파일을 두는 폴더
        /webapp     <= 웹 어플리케이션 관련 파일을 두는 폴더
      /test
        /java       <= 자바 테스트 소스 파일을 두는 폴더
        /resources  <= 자바 테스트 관련 설정 파일을 두는 폴더

이유?
국제적으로 프로그램을 저장할때 이 구조를 많이 사용하고 있어서.
국제 표준처럼 사용되고 있어서.
국제 표준.



* build 도구
build - 컴파일, 배포파일 생성, 테스트, 문제생성 등 개발 전과정을 말하는 용어
 ㅣ
 1. ant - build.xml [설정파일에 빌드 작업을 기술한다.]
 2. Maven - pom.xml [ant에서 Maven으로 대세가 바뀐 이유 ㅡ> 의존 부품(Library) 자동관리]
 3. Gradle - build.gradle [Maven에서 Gardle로 대세가 바뀐 이유 ㅡ> groby 언어를 도입하여 복잡한 빌드 작업을 기술할 수 있도록 함.]

gradle 설치 후 환경변수 등록해주고(bin폴더 까먹지말고!)
> gradle -version

Gradle 빌드 도구를 이용하여 Maven 프로젝트 구조로 디렉토리를 자동 생성하기
> gradle init --type java-application
  => gradle 빌드 도구 관련 설정 파일들이 자동으로 생성된다.
  => 또한 Maven 프로젝트 구조에 맞춰서 폴더들이 자동생성된다.
  => 간단한 예제 파일이 자동 생성된 폴더에 저장된다.

gradle init --type java-application
- gradle이 우리를 대신해서 src와 main test 폴더를 만들어줌.(샘플예제도)
.gradle 폴더 신경쓰지말것.(만지지 말것.)


build.gradle 파일
  => 자동으로 생성된 파일 중에서 개발자가 직접 손대는 파일.
  => 이 파일에 빌드에 관련된 작업 내용을 기술한다.
  => 작업 명령은 groovy라는 언어를 사용해서 기술한다.
  => groovy는 자바 호환 언어이다. 즉 자바와 함께 사용할 수 있다.
  => 빌드 작업을 작성하는 자세한 사항은 문서를 보라.(gradle 관련 문서.)

* 자바 호환 언어란?
=> 컴파일하면 .class 파일을 만드는 언어.
=> 바이너리 수준(bytecode 수준)에서 호환된다.
=> 따라서 자바로 만든 모든 코드를 100% 사용할 수 있고,
   자바에서도 호환 언어로 작성된 코드를 100% 사용할 수 있다.
=> 예) Scala, Groovy, Kotlin 등이 있다.

외국은 쉬운 언어가 나오면 바로 쓴다.
우리나라는 배워둔 자바가 아까워서 새로 나온 쉬운 언어를 안쓴다.

Gradle을 이용하여 프로젝트를 빌드한다.
> gradle build
  => 1) 의존하고 있는 외부 라이브러리를 자동으로 다운로드 받는다.
  => 2) build라는 폴더를 생성한다.
  => 3) build 폴더에 컴파일된 파일들을 놓인다.
  => 4) 테스트 프로그램이 있으면 실행한다.

라이브러리란?
- 개발자가 만든 코드들의 묶음
- 보통 .jar 파일에 묶여서 배포된다.
- JAR(Java Archive)의 약자이다.
- "archive"는 묶음을 의미한다.
- 그런데 영어 사전에 "jar"라는 단어가 있다.
  jar의 의미는 "(꿀)단지"라는 뜻이 있어 묶음이라는 의미를 표현해 준다.
- 압축을 할 때는 zip 알고리즘(압축공식)으로 압축한다.
  왜? zip 알고리즘은 특허로 등록되어 있지 않다.(개발자-필 캐츠...가 히트칠줄 몰라서 등록하는걸 깜빡하거나 하지 않았다.)
  무료인덕에 zip 알고리즘(압축공식)이 가장 많이 쓰인다.(하지만 개발자는 자괴감에 쓸쓸하고 처량하게 죽었다.)

필 캐츠...
빌 게이츠 - 생각의 속도.
스티브 잡스(보급판)
조너선 아이브

습관의 중요성
공부도 습관. 업무도 습관. 스마트한 업무 보고. 업무처리 능력.

libs 배포파일(친구나 고객에게)
>cd build
>cd libs
나중에 마저 이어서..

테스트 파일들 실행되는 속도, 통과 여부(결과)까지 확인가능.

main - java 폴더에 Test04.java를 옮긴후 cmd를 실행해서 프로젝트파일(java-basic 폴더)로 가서 >gradle tasks 를 입력하면 테스트 할수 있는 파일들이 나옴. 여기서 >gradle classes를 입력.
>set CLASSPATH=C:\Users\bit-user\git\java100\bitcamp-java-basic\build\classes\java\main(선생님 파일 경로.)
>set CLASSPATH=C:\workspace\java-basic\build\classes\java\main (내 파일 경로.)
>java Test05


*/

class Test05 {
  public static void main(String[] args) {
    System.out.println("안녕하세요!");
  }
}