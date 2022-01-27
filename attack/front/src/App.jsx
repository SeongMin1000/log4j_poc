import "./style.css";

function App() {
  var requestURL =
    "https://raw.githubusercontent.com/publdaze/movieWebWithReactJS/main/DE/test/test.json";

  var request = new XMLHttpRequest();
  request.addEventListener("load", reqListener);
  request.open("GET", requestURL);
  request.responseType = "json";
  request.send();

  function reqListener() {
    var datas = request.response;
    maketable(datas);
  };

  function maketable(jsonObj) {
    var myTbody = document.getElementById("tbody");

    while (myTbody.firstChild) {
      myTbody.removeChild(myTbody.lastChild);
    } //  남아있던 기록 지움
    console.log(jsonObj[1]);
    console.log(jsonObj.length);
    for (var i = 0; i < 5; i++) {
      var myTr = document.createElement("tr");
      var myTd1 = document.createElement("td");
      var myTd2 = document.createElement("td");
      var myTd3 = document.createElement("td");

      myTd1.textContent = jsonObj[i].id;
      myTd2.textContent = jsonObj[i].ip;
      myTd3.textContent = jsonObj[i].connection_date;

      myTr.appendChild(myTd1);
      myTr.appendChild(myTd2);
      myTr.appendChild(myTd3);

      myTbody.appendChild(myTr);
    } // child (data) 추가
  }

  return (
      <div className="content">
        <table>
          <thead>
            <tr>
              <th>id</th>
              <th>ip</th>
              <th>connection_date</th>
            </tr>
          </thead>
          <tbody id="tbody"></tbody>
        </table>
      </div>
  );
}

export default App;
