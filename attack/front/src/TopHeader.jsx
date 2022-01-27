import "./style.css";
import logo from "./img/치우_로고.png";

function TopHeader() {
  return (
    <div className="top_header">
      <img src={logo} alt="logopng" style={{ height: '5em', width: 'auto' }} />
      <div className="top_font">NaaaRak</div>
      <div className="top_img"></div>
    </div>
  );
}

export default TopHeader;
