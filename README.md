
# SpringBoot-Project-NKY-Board
스프링 부트 + JPA 로 개발한 CRUD 게시판

접속 링크 : < http://3.38.243.119:8080/ >
<br>

### ⚙️ 개발 환경
- **JAVA** : openjdk 11.0
- **IDE** : intelliJ
- **Framework** : Springboot(2.7)
- **Database** : AWS RDS (MySQL 8.0)
- **ORM** : JPA
- **Server** : AWS EC2(ubuntu)
## 📌 주요 기능
#### 로그인  
- DB값 검증
- 로그인 시 쿠키(Cookie) 및 세션(Session) 생성
#### 회원가입 
- ID, PASSWORD 중복 체크, 유효성 검사
#### 게시글에 대한 쓰기,수정,삭제
- 회원 전용 기능(비회원은 로그인 필요 팝업창 안내) 
- JPA 를 이용한 게시판 CRUD 기능
#### 페이징, 검색 
- 조회된 게시글에 대한 페이징 처리
- 게시글 수정,삭제,내용보기 후 검색어 유지
#### 댓글, 대댓글
- 회원 전용 기능(비회원은 로그인 필요 팝업창 안내) 
- 게시판에 대한 댓글과 대댓글 기능 구현(+ 삭제 기능)


## 📌 추가 예정

#### 회원 탈퇴 기능
- 회원 탈퇴
- 회원 탈퇴 후 관련 게시글 과 댓글에 대한 처리

#### 관리자 페이지 
- 회원 관리
- 게시글 관리

#### CI/CD
- Github Action 과 AWS CodeDeploy 로 구성된 자동 빌드/배포 파이프라인 구현
 
