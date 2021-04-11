# Softbank OJT



[TOC]

# 화면 개발





## 1. 과제 소개

Web Server: Nginx

WAS: Wildfly







Nginx

문제점: 서버 실행이 안 됐다

원인: 80포트가 사용중이어서 실행되지 않았음(실행 후 제대로 종료되지 않아서 캐시를 잡아먹고 있었던 것으로 추정)

해결: `nginx.conf` 파일에서 server를 81로 바꿔서 실행함

보충

- `nginx.conf`에서 많은 일을 할 수 있는데, 포트 번호를 바꾸거나 root를 수정하여 서버가 실행될 때 어디에 있는 html파일을 열지 설정할 수 있음
- 프롬프트에서 `netstat -a` 명령어를 통해 현재 사용되고 있는 포트번호를 확인 가능