import React from "react";
import {
    BrowserRouter,
    Routes,
    Route
} from "react-router-dom";
import styled from "styled-components";
import MainPage from "../src/component/page/MainPage";
import PostWritePage from "../src/component/page/PostWritePage";
import PostViewPage from "../src/component/page/PostViewPage";

const MainTitleText = styled.p`
  font-size: 24px;
  font-weigth: bold;
  text-align: cneter;
`;

function App(props) {
  return (
      <BrowserRouter>
          <MainTitleText>Mini Blog</MainTitleText>
          <Routes>
              <Route index element={<MainPage />} />
              <Route path="post-write" element={<PostWritePage />} />
              <Route path="post/:postId" element={<PostViewPage />} />
          </Routes>
      </BrowserRouter>
  );
}

export default App;
