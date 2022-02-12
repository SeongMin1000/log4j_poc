import React, {useState} from "react";
import "./style.css";
var i = 1;
function Comment() {
  const [chatting, setChat] = useState("");
  const rootDiv = document.querySelector("#comments");
  const mainCommentCount = document.querySelector("#count"); //맨위 댓글 숫자 세는거.

  //타임스템프 만들기
  function generateTime() {
    const date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth();
    const wDate = date.getDate();
    const hour = date.getHours();
    const min = date.getMinutes();
    const sec = date.getSeconds();

    const time =
      year + "-" + month + "-" + wDate + " " + hour + ":" + min + ":" + sec;
    return time;
  }

  //유저이름 발생기
  //유저이름은 8글자로 제한.
  function generateUserName() {
    var makeUsername = "익명";
    makeUsername += i++;
    return makeUsername;
  }

  function deleteComments(event) {
    const btn = event.target;
    const list = btn.parentNode.parentNode; //commentList
    rootDiv.removeChild(list);
    //메인댓글 카운트 줄이기.
    if (mainCommentCount.innerHTML <= "0") {
      mainCommentCount.innerHTML = 0;
    } else {
      mainCommentCount.innerHTML--;
    }
  }

  //댓글보여주기
  function showComment(comment) {
    const userName = document.createElement("div");
    const inputValue = document.createElement("span");
    const showTime = document.createElement("div");
    const countSpan = document.createElement("span");
    const commentList = document.createElement("div"); //이놈이 스코프 밖으로 나가는 순간 하나지우면 다 지워지고 입력하면 리스트 다불러옴.
    //삭제버튼 만들기
    const delBtn = document.createElement("button");
    delBtn.className = "deleteComment";
    delBtn.innerHTML = "삭제";
    commentList.className = "eachComment";
    userName.className = "name";
    inputValue.className = "inputValue";
    showTime.className = "time";
    //유저네임가져오기
    userName.innerHTML = generateUserName();
    userName.appendChild(delBtn);
    //입력값 넘기기
    inputValue.innerText = comment;
    //타임스템프찍기
    showTime.innerHTML = generateTime();
    countSpan.innerHTML = 0;

    //댓글뿌려주기
    commentList.appendChild(userName);
    commentList.appendChild(inputValue);
    commentList.appendChild(showTime);
    //commentList.appendChild(voteDiv);
    rootDiv.prepend(commentList);

    delBtn.addEventListener("click", deleteComments);
  }

  //버튼만들기+입력값 전달
  function pressBtn() {
    var inputBar = document.getElementById("comment-input");
    console.dir(inputBar);
    const currentVal = inputBar.value;
    if (!currentVal.length) {
      alert("댓글을 입력해주세요!!");
    } else {
      showComment(currentVal);
      mainCommentCount.innerHTML++;
      inputBar.value = "";
    }
  }

  const onKeyPress = (e) => {
    if (e.key === "Enter") {
      var inputBar = document.getElementById("comment-input");
      console.dir(inputBar);
      const currentVal = inputBar.value;
      if (!currentVal.length) {
        alert("댓글을 입력해주세요!!");
      } else {
        showComment(currentVal);
        mainCommentCount.innerHTML++;
        inputBar.value = "";
      } 
    }
  };

  const onChange = (e) => {
    setChat(e.target.value);
  }

  return (
    <div>
      <div id="form-commentInfo">
        <div id="comment-count">
          댓글 <span id="count">0</span>
        </div>
        <input
          id="comment-input"
          onKeyPress={onKeyPress}
          value={chatting}
          onChange={onChange}
          placeholder="댓글을 입력해 주세요."
        />
        <button id="submit" onClick={pressBtn}>
          등록
        </button>
      </div>
      <div id="comments"></div>
    </div>
  ); 
}

export default Comment;
