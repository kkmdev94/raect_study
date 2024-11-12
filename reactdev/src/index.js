import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
// import App from './App';
import reportWebVitals from './reportWebVitals';

// import Library from './chapter_03/Library'; //다시 듣기
// import Clock from './chapter_04/Clock'; //다시 듣기
// import CommentList from './chapter_05/Commentlist'; //다시 듣기
// import NotificationList from './chapter_06/NotificationList'; //다시 듣기
// import Accommodate from './chapter_07/Accommodate';  //다시 듣기
// import ConfirmButton from './chapter_08/ConfirmButton'; //class bind 방식
// import ConfirmButtonF from './chapter_08/ConfirmButton(fun)';
// import LandingPage from './chpater_09/LandingPage';
// import AttendanceBook from './chapter_10/AttendanceBook';
// import SingUp from './chapter_11/SingUp';
// import Calculator from './chapter_12/Calculator';
// import ProfileCard from './chapter_13/ProfileCard';
// import DarkOrLight from './chapter_14/DarkOrLight';
// import Blocks from './chapter_15/Blocks';
import App from './App';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <App/>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
