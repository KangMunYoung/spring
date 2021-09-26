/**
 * 회원가입 모달창 관련 스크립트
 */
const openJoinBotton = document.getElementById('joinBtn'); //회원가입 버튼
const nextJoinBotton1 = document.getElementById('joinNextBtn'); // 회원가입 다음버튼 1
const cancelJoinBtton = document.getElementById('joinCancelBtn'); // 취소버튼
const loginJoinModal = document.querySelector('.loginJoinModal');

const modalOverlay = loginJoinModal.querySelector('.modalOverlay');

//모달창 실행
const openJoinModal = function () {
  loginJoinModal.classList.remove('modalHidden');
};

//취소 클릭 이벤트
const nextJoinModal1 = function () {
  loginJoinModal.classList.add('modalHidden');
};

const closeJoinModal = function () {
  loginJoinModal.classList.add('modalHidden');
};
//회원가입 다음버튼 누르면 동작 실행 바꿔야함!!!!!!!!!!!!!!!!!
cancelJoinBtton.addEventListener('click', nextJoinModal1);

// 모달창 종료이벤트 실행
modalOverlay.addEventListener('click', closeJoinModal);
nextJoinBotton1.addEventListener('click', closeJoinModal);

//회원가입창 클릭시 모달창 오픈
openJoinBotton.addEventListener('click', openJoinModal);

//체크박스 전부 선택
$(document.querySelector('.allJoinCheckbox')).ready(function () {
  $('.allJoinCheckbox').click(function () {
    $('.joinCheckbox').prop('checked', this.checked);
  });
});

//오버레이 클릭시 모달창 닫기
$('.modalOverlay').on(function () {
  $(this).addClass('.modalHidden');
});
