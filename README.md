# MMMMeeting
<br>
// 2020.11.23(윤지)<br>
* UI 변경<br>
- main : 생성,참가 버튼만 남기고 탈퇴버튼 삭제, 모임 목록 2개씩 보이도록 변경<br>
- meeting info : 탈퇴 버튼 생성(모든 버튼 이미지로 변경), 모임원 1명이면 모임장 양도 불가 <br>
* delete activity 변경 => intent로 code를 받아와서 직접 입력할 필요x <br>

<br>
// 2020.11.22(주영) <br>
 * UI 변경 <br>
 - 투표 화면에 툴바 추가 <br>
 - 약속의 체크 이미지 -> 점점점 이미지로 변경 <br>
 - 캘린더 화면에 툴바 추가하고 버튼들 이미지로 변경 <br>
 - 게시판에 수정버튼도 고양이길래 점점점 이미지로 변경함 <br>
<br>

// 2020.11.22(은아)<br>
 *장소 추천 오류 수정 <br>
 -출석 점수 음수 -> 절댓값 + 역수로 계산<br>
 -추천 목록 영어 -> 한글 + 단위 표시 <br>
 -출석점수 -> 분산 적용시 분산 값이 제대로 적용 X => 분산 -> 출석점수 반영으로 수정 <br>
 -범위 내에 검색결과 없을 경우 -> Toast Message 띄워서 현재 범위내 장소 없음 알림 <br> 
 -분산 가중치 기준 : 3점 -> 해당 유저의 별점 중앙값 
 
<br>
// 2020.11.21(윤지)<br>
 * 이동시간에 따른 중간지점 찾기<br>
 - centroid들을 이용해 거리상 평균점구하기-> 인원수에 비례하게 평균점 구함<br>
 - 평균점까지의 이동시간이 인원수에 비례하도록 평균점 이동시킴 -> 평균 이동시간을 줄이는 방향으로 update<br>
 - 현재 평균시간이 이전 평균시간보다 커질 때 이전 평균점을 중간지점으로 선택!<br>

<br>
// 2020.11.21 변경(수현) <br>
 * 약속 수정 오류 업데이트 <br>
 - 약속 수정하면 db에 있는 정보가 다 사라지는 오류 해결 <br>
 - 추후에 약속, 게시판 관련 코드 간결하게 만들어보겠음 <br>
 => 처음에 뭐가 뭔지 모르고 코드를 다가져와서.. 필요한 부분만 남기겠음 <br>
<br>

// 2020.11.21 변경(은아) <br>
 *정산 화면 업데이트 <br>
 -탭 빠르게 전환시 에러 발생 해결<br>
   : 레이아웃 동적 생성시 getContext에서 에러발생 -> listView로 출력하도록 수정 <br>
 -아무것도 입력하지 않거나 숫자가 아닌 값 (문자나 이모티콘) 입력시 안내 메시지 출력 <br>
 -여러번 수정할 때 에러 
   : listview로 바꾼 후 어디서 에러나는지 확인하려고 해 봤는데 에러 발생 X  => 확인 필요<br>
<br>


// 2020.11.20 변경(은아) <br>
 *출석 화면 업데이트 <br>
 -reset 누르면 버튼 사라짐 수정<br>
 -reset 당일 출석 점수 반영<br>
<br>

// 2020.11.20 변경(수현) <br>
 *출석 화면 업데이트 <br>
 -시간별로 점수 지정, 동점자 순위 반영<br>
 -모임 시간 지나도 출석체크 가능<br>
 -에뮬레이터에서 출첵하기 위해 약속 좌표를 구글 근처로 바꿨습니다<br>
 CurrentMapAct에서 ##주석 지우면 원래 코드로 돌아감!<br>
 
<br>
// 2020.11.18 변경(주영) <br>
 * 개별 알림 설정 <br>
 - 약속 꾹 누르면 알림 받을 수 있음<br>
 - 정해진 약속 날짜가 없으면 메시지만 띄움<br>
 - 알림 메시지에 약속 시간이랑 모임 이름 넣음<br>
 
<br>
// 2020.11.18 변경(은아) <br>
 * 출석 점수 리셋버튼 생성 <br>
 -> 방장만 리셋버튼 보임<br>
 -> 리셋 누르면 확인창 -> 예 = 리셋 / 아니오 = 유지<br>
 -> title 밑에 reset 날짜 확인 가능<br>

<br>
// 2020.11.17 변경(수현) <br>
* 출석체크 오류 수정 <br>
-> 약속 시간, 장소 안 정했을 때 오류 수정 <br>
-> 분 단위가 5분 보다 작아서 시 단위도 바뀌는 경우 반영 <br>
-> meetingPlace String에서 Map으로 바껴서 오류나는거 수정 -> 다른 코드에도 있나 확인해보겠음 <br>

<br>
// 2020.11.16 변경(은아) <br>
* 지각자 화면 안 나오는 문제 수정 <br>
-> 화면 이름 지각자 ==> 출석으로 변경 <br>
* 사용자 범위 변경 단위 500으로 변경 <br>
* 반경마다 별점:거리 가중치 비율 다르게 적용되도록 <br>
-> 1000 미만 = 1:3 // 2000 미만 = 1:1 // 2000 이상 = 3:1 <br>
* 카테고리 계산 시 출석점수 반영 <br>
-> 출석 점수를 가중치로 생각하고 기존 별점에 출석 점수*0.1 한 값을 곱함<br>


<br>
// 2020.11.15 변경(은아) <br>
* seekbar로 검색 범위 사용자 변경가능<br>
-> 100단위 변경 <br>
* 카테고리 선택 기준 : 사용자들 분산의 중앙값으로 변경 <br>
* 별점, 장소 이상하게 나오는 거 수정<br>


<br>
// 2020.11.15 변경(윤지) <br>
* 투표리스트에 이미 존재하는지 확인(checkList)<br>
-> 존재하면 추가 불가, 삭제 가능/ 존재하지 않으면 추가 가능, 삭제 불가 <br>
* 장소검색에 투표 삭제 버튼 생성<br>

<br>
// 2020.11.15 변경(주영) <br>
* db에 저장되는 최종장소 변경<br>
- name : 장소 이름<br>
- latlng : 위도, 경도<br>

<br>
// 2020.11.15 변경(수현) <br>
* 출석체크에 실시간 위치 반영<br>
- 출석 5분전에 지도 화면으로 들어갈 수 있음<br>
- 1. 출석체크 버튼 누르면 현재 위치가 500m 이내인지 체크 (계속 체크하고 있으면 호출 많아질거 같아서)<br>
- 2. 500m 이내: 약속시간 전인지 다시 체크 (화면에 오래 머물러서 시간 지나는 경우 방지)<br>
->시간 이내면 db에 등록<br>
->시간 지났으면 화면 종료됨<br>

<br>
// 2020.11.14 변경(주영) <br>
* 방장과 투표 상태에 따른 투표 버튼 변경<br>
- 투표 state : valid, invalid, done<br>
-> 투표 종료 후(done) : 투표 목록도 안보이고 종료된 투표라고 뜸<br>
-> 투표 목록이 아예 없으면 생성된 목록이 없다고 뜸<br>
<방장> <br>
-> 투표 시작 전(valid) : 시작 버튼만 보임<br>
-> 투표 중(invalid) : 완료 버튼과 종료 버튼만 보임<br>
<일반 모임원><br>
-> 투표 시작 전(valid) : 아무 버튼이 없음(투표 목록은 보임 --> 안보이게 할까..?)<br>
-> 투표 중(invalid) : 완료 버튼만 보임<br>
* 투표중 수정 가능<br>
- 자신이 투표했던건 다시 들어가도 표시돼있음<br>
- 종료 전까지 수정 가능<br>

<br>
// 2020.11.14 변경(윤지) <br>
* 투표 오류 수정 -> 다시 들어와도 투표 오류x, 한 번에 여러개 추가 가능 <br>

<br>
// 2020.11.14 변경(주영) <br>
* 달력에서 날짜 선택을 방장만 할 수 있게 수정<br>
- 날짜 선택 버튼이 방장일 때만 보임<br>

<br>
// 2020.11.12 변경(소연) <br>
* placelist수정<br>

<br>
// 2020.11.11 변경(주영) <br>
* 투표에서 방장만 투표 시작과 종료 버튼이 보이게 함<br>
- 일반 유저는 투표 완료하면 종료 / 방장은 시작, 종료 버튼을 누를 수 있음<br>
* 투표하면 장소에 투표한 유저의 아이디가 올라가게 함<br>

<br>
// 2020.11.08 변경(윤지) <br>
* 투표 db 생성 -> 약속 id, 장소 이름, 위치, 투표 수 저장 -> 관련 info(VoteInfo)<br>
* 투표 db 저장 <br>
 - 버튼 누르면 db에 저장/ 다시 누르면 db에서 삭제 (다른 카테고리로 변경했다가 다시 돌아오면 리셋상태)<br>
 - place 5개 넘어가면 더이상 저장x <br>
 - 저장한 장소 또 눌러도 '저장되었습니다'라고 뜸(db에는 동일한 장소가 이미 있으므로 변화x)<br>
 - SearchPlace에서 장소 검색 후 투표 추가 가능<br>
 * 수정할 부분 -> 이미 저장된 장소는 체크 표시가 뜨도록 변경 <br>

<br>
// 2020.11.08 변경(수현) <br>
* 카테고리+점수 반영한 장소 정렬<br>
- rating:거리점수 = 4:6으로 설정 -> 변경 가능 <br>
거리 점수가 0~3.5점 사이여서 저 비율로 설정하면 실제로는 5:5 비율일듯 <br>
- 화면 넘어가게 하려고 중간지점 마들역으로 바꿨어요! <br>
원래 코드로 돌아가려면 -> MeetingActivity에서 ##로 시작하는 문장 지우고 #로 시작하는 주석 지우면 됨 <br><br>
* 출석체크 업데이트 <br>
- 버튼 빨리 누르면 제대로 인식 못 하는거 수정함 <br>
- flag 없애고 버튼 누르면 메세지 띄우고 화면 종료되도록 변경(광클 방지..) <br>


<br>
// 2020.11.07 변경(은아) <br>
* 카테고리 추천
- 모임원의 선호도 기준으로 상위 3개 카테고리 선택 <br>
- 각 카테고리에 대해 범위 내 장소 출력 (카페, 식당 = 500m / 나머지 = 1000m) <br>
- 카테고리에 해당하는 장소가 범위 내에 없으면 못 찾았다는 글 띄움 <br>


<br>
//2020.11.07 변경 (소연) <br>
* 지각자 업데이트 <br>
- 출석체크 일찍한 사람 순서대로 순위 보여줌(모임의 모든 약속에 대한 순위임) <br>

<br>
//2020.11.07 변경 (수현) <br>
* 출석체크 업데이트 <br>
- 일정 5분 전부터 출첵 할 수 있게 업데이트 <br>
- 일정 5분 전, 일정 한참 전, 일정 지난 후 나오는 메세지 다르게 설정 <br>
- 지각해도 딜레이 때문에 버튼이 보여서 1초만에 클릭하면 출첵이 되길래 <br>
버튼 못 누르게 설정하고 일정 화면 3초 동안 보여주고 종료되도록 변경 <br>

<br>
//2020.11.06 변경 (주영) <br>
* 알림 기능 생성 <br>
* 일정에 시간 확정 기능 생성 <br>
- 캘린더에서 날짜 확정하면 시간 정하는 화면으로 넘어가고 시간 설정하면 알림 설정됨<br>
- 약속마다 알림 가능하게 함 <br>
- 한시간 전에 알림오게 함 <br>
* 보완 필요한 점: 알림 클릭하면 시간 설정하는 화면으로 들어오는데 아예 없애거나 다른 화면이 좋을듯 <br>
알림 메시지에 모임 이름같은 것도 띄워주면 좋을듯<br>

<br>
//2020.11.06 변경 (수현) <br>
* 출석체크 생성 <br>
- 일정을 누르면 언제?/어디서?/출석체크 버튼을 제공함 <br>
- 각 일정 문서를 DB에서 찾아서 해당 meetingDate를 날짜로 설정함 <br>
- 현재 시간이 모임 시간보다 늦으면 출석체크 버튼을 누르지 못함 + 창에 들어갔다가 나와짐 <br>
- 현재 시간이 모임 시간보다 이르면 창에 들어가서 출석체크 버튼을 누를 수 있음 -> db lateComer에 저장됨(타이틀 바꿀 예정) <br>
* 보완 필요한 점: 지도랑 반반 화면을 구성하면 지도가 나오지 않고 중간에 튕김 -> 현재 위치랑 비교하면 좋을텐데.. <br>
출석체크 버튼을 모임 전이면 언제나 누를 수 있어서 시간 조정 필요<br>

<br>
//2020.11.06 변경 (은아) <br>
* 모임장 생성 <br>
- 모임 생성한 사람 - 자동 모임장 설정 <br>
- 모임장 양도 - 이름 입력해서 양도 (모임장인 경우만 양도 버튼 존재 = 다른 액티비티) <br>
(팝업이나 목록에서 선택해서 하게 하고 싶었는데 DB 시간 문제 때문에 새로운 액티비티에서 이름 입력받아 양도 진행) <br>
- 모임장이 양도하지 않고 모임 탈퇴, 회원 탈퇴하는 경우 - 모임원 중 임의로 새로운 모임장 선정 <br>
* 카테고리 추천
- 1순위 카테고리에 속하는 장소 추천
- 범위내 장소 없는 경우 장소 추천 안됨 - 해결 중..
<br>

<br>
//2020.11.06 변경 (소연) <br>
* 중간지점 <br>
- 중간지점에서 장소리스트로 넘어갈 수 있도록 함(PlaceListActivity : 장소 리스트 보여줌)
- 좋아요버튼 추가(아직은 형태만 있고 db랑 연동해서 사용자들이 좋아요누른거 모두 반영할 수 있도록 할 예정)
<br>

<br>
//2020.11.05 변경 (윤지) <br>
* 중간지점 <br>
- 중간지점 근처 지하철역을 중간지점으로 마커 표시<br>
- 500미터 내에 없으면 역이 존재할 때까지 500미터씩 늘려서 가장 가까운 역으로 
<br>

<br>
// 2020.11.04 오전 12:16 변경 (소연) <br>
* 정산 : 정산결과에 수정하기 버튼 추가(다시 정산 입력창으로 돌아감)
<br>

<br>
// 2020.11.03 변경 (소연) <br>
* 정산 :  다른 메뉴 눌러도 정산결과 안바뀌고 그대로 보이도록 
<br>

<br>
// 2020.11.03 변경 (은아) <br>
* 회원 정보에서 이름, 주소 필수 입력으로 변경 (주소 없어서 중간지점 찾기 에러나는거 방지)<br>
* 앱 아이콘 이미지 변경<br>
* 정산 이름이 잘려나와서 레이아웃 크기 변경 
<br> + 초기값 0으로 세팅 안 되는거랑 입력 안 되있는 값 자동으로 0 입력되는거 안 돌아가길래 이거 살짝 수정함<br><br>

<br>
//2020.11.02 변경 <br>
* 중간지점 - 모임원들의 주소를 받아 중간지점 찾음(모임원,중간지점 marker 변경) <br>             
* 예시 <br>
<img src="https://user-images.githubusercontent.com/72245168/97830813-99fbd600-1d11-11eb-8e40-b5815022a6de.PNG" width="30%"></img>
<img src="https://user-images.githubusercontent.com/72245168/97830854-b566e100-1d11-11eb-9b6c-58456480613a.PNG" width="30%"></img>


//2020.11.02 변경 <주영 - 캘린더><br> 
-> firebase에 전부 연결<br> 
-> 메모(일정), 되는 날짜 표시(동그라미), 확정 날짜 전부 됨<br> 
-> 확정한 날짜는 네모 표시함<br> 


<br>//2020.11.02 변경 <카테고리 추천>
 * categorySelect 클래스에 작성됨
 * 다른 클래스로 category 값 전달 불가 -> 추천 카테고리 선택에 시간이 걸려서, 선택 전의 값이 전달됨<br>
  -> 카테고리 추천이 필요한 곳에 categorySelect 클래스에 있는 모든 함수 이동 필요..<br>

<h1>* 모임 분리 방법!!</h1>
특정 액티비티 or 프래그먼트에서 미팅 이름 전달 -> 전달 받음 -> DB에서 미팅 이름을 포함하고 있는 데이터 가져옴 <br><br>

* <intent사용!!> <참고: FragHome- myStartActivity 함수> <br>
액티비티->액티비티 or 프래그먼트->액티비티 <br>
Intent intent = new Intent(getActivity(), 클래스이름.class); <br>
intent.putExtra("Name",meetingName); <br><br>

* <bundle사용!!> <참고: MeetingActivity- case R.id.menu_home 부분> <br>
액티비티->프래그먼트 or 프래그먼트->프래그먼트 <br>
bundle.putString("Name", getIntent().getExtras().getString("Name")); <br>
프래그먼트이름.setArguments(bundle); <br><br>

* DB에서 데이터 가져오기 <참고: FragHome- postsUpdate 함수> <br>
// 스케쥴 테이블 접근 <br>
CollectionReference collectionReference = firebaseFirestore.collection("schedule"); <br>
// 스케쥴 테이블의 문서 접근 <br>
for (QueryDocumentSnapshot document : task.getResult()) <br>
// 문서에 미팅ID가 미팅 이름과 같으면 동작! <br>
if(document.getData().get("meetingID").toString().equals(meetingName)){ <br>
    //예시- 문서의 스케쥴 제목 가져오고 싶을 때 <br>
    String title = document.getData.get("title").toString() -> 문서의 타이틀 이름을 string으로 가져옴 <br>
} <br>


//2020.10.29 변경 사항
<br>
 * 중간지점 찾기
 -> 모든 user의 주소를 이용해 중간지점 찾음 <br>
 * 추가된 Activity >> GrahamScan, Point, Stack <br>
 * 수정된 Activity >> MiddlePlaceActivity <br>

 * 회원정보 입력창에 별점 입력, DB 저장 (Map 형식)
 * 모임나가기, 회원 탈퇴시 모임방 인원이 0명이 되면 그 모임 DB에서 삭제<br>
  -> 모임 나가기에서 동작 확인, 회원 탈퇴 모임방 나가기 코드 복붙 (테스트 X)


// dev branch 코드 변경
* 모임 참가, 모임 탈퇴 버튼 동작 (코드 입력시 해당 코드 모임 참가 / 탈퇴)
* 모임방 클릭시 (grid item 클릭시) 모임 방 내부로 들어가기 동작
* UI 변경 (기존 GridView => Main으로 통합)

// 흐름도 <br>
SignAct -> MainAct(초기 화면) -> GridAdapter(모임 목록 관리) -> MeetingAct(한 모임 내부) <br>
-> FragHome(약속 목록 홈 화면) -> MakeScheduleAct(약속 만들기) -> ScheduleAdapter(약속 목록 관리)-> <br>
ContentScheduleAct(약속 내용 보기/날짜, 장소 정하기) -> <br>
<h1>★주영 코드 부분★</h1>
1. CalendarAct(공유 달력) - activity_calendar.xml 
-> db에서 모임이름 받아오기
-> 약속장소 저장하기
<h1>★소연 코드 부분★</h1>
2. PlaceChoiceAct(장소 선택)<br>
*1.MiddlePlaceAct(중간지점) - activity_place_middle.xml<br>
*2.SearchPlaceAct(장소찾기) - activity_place_search.xml <br>
<br><br>
//2020.10.23 변경 사항
<br>
*추가된 Activity >> DirectionActivity, GpsTracker, SampleItem<br>
*추가된 xml >> activity_direction_map<br>
<br>
수정사항<br>
* UI 정리 ( 추천경로와 그 외의 경로를 보여줌 , 경로를 선택하면 상세정보를 볼 수 있음)<br>
* Polyline 합치기 (선택된 경로의 Polyline을 볼 수 있도록 수정함)<br>
* 아직 코드 정리가 안돼서 다시 정리하고 주석 달아서 올릴 예정임
<br><br>

<br><br>
// 2020.10.21 변경
* 약속 화면 추가
* 캘린더/장소 선택 화면 추가
* 게시판 이동
* 메뉴 탭 변경 (홈/채팅/게시판/지각자/정산)
* schedule db에 올라가는거 확인 했습니다 (모임 ID는 임의로 넣었는데 곧 추가해야 할듯)

<br><br>
// 2020 .10 .20 변경
* 주소 검색
* 주석 추가
* 그리드뷰 디자인 변경
* 회원정보 -> 이름 입력값 유지
* 회원 탈퇴시 모임원에서도 삭제

<br><br>
// 2020 .11 .1 변경
* 정산부분 (나중에 시간 남으면 정산결과 게시글로 바로 올릴 수 있는 버튼 구현하면 좋을 것 같음)
<br>

//해야 함
<h1>★ 1. 중간지점 ★</h1>

1. meeting마다 속하는 모임원들의 주소만을 이용하도록 변경 => 함
2. 최적의 중간지점을 찾는데 시간 단축 필요
3. 모임원들이 많이 모여있는 지역 고려 필요

// 해야하지 않을까?
1. 모임 탈퇴시 유저가 하나도 없으면 해당 모임 삭제 => 함 <br>
  -> 삭제되는 모임의 게시된 약속, 게시판 관련 정보도 삭제될 수 있도록 하면 좋을 것 같다..
2. 회원 탈퇴시 유저가 속한 모임 방에서 유저 id 삭제 => 함
3. 모임 생성시 중복 이름 불가능하게 (현재 모임 초대시 모임 코드 선택해서 전송되는데 이름으로 모임코드 확인함) => 함



<br><br>
***************************************************************************
com.example.mmmmeeting

***Firebase 팀 아이디 만들었어요!!

아이디: mmmcapstone@gmail.com <br>
비밀번호: (영어로)컴종설!


