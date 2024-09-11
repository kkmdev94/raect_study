FROM node:20-alpine

WORKDIR /home

# 패키지 설치 단계(패키지 설치와 빌드 단계를 분리 해서 패키지가 변경되었을때만 설치되도록 입력.)
COPY ["package.json", "package-lock.json", "public/index.html", "./"]
RUN apk add --no-cache git
RUN apk add --no-cache curl
RUN ["npm", "install"]


# 빌드 단계

WORKDIR /home

RUN git clone https://github.com/kkmdev94/raect_study.git

WORKDIR /home/HP_frontend

ENV CHOKIDAR_SUERPOLLING=ture

EXPOSE 3000

CMD ["npm", "run", "start"]
#CMD ["node", "./public/index.html"]