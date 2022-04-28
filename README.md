# AnchorServer

:leaves: Spring Boot

# :pushpin: API

## book

### GET
api/book/findAll : 모든 책 리스트 리턴  
api/book/findAllSeries : 모든 시리즈 리스트 리턴  
api/book/find/id (@RequestParam long id) : 책 id로 책 정보를 리턴  
api/book/find/name (@RequestParam String containWord) : 책 이름으로 책 리스트를 리턴  
api/book/find/series (@RequestParam Long id) : 시리즈 내의 모든 책 리스트 리턴  
api/book/commentedBook @RequestParam Long userSeq : 특정 유저가 코멘트를 작성한 책 리스트 리턴  

### POST

## comment

### GET
api/comment/findAll : 모든 코멘트 리스트 리턴  
api/comment/find : 해당 id를 가진 책에 달린 코멘트 리스트 리턴
api/comment/find/userseq (@RequestParam Long userSeq : 유저 id별 작성한 코멘트 조회


### POST
api/comment/createComment : 코멘트 생성 api  

### DELETE
api/comment/delete/{id} : 코멘트 삭제 api

## likes

### GET
api/likes/comment (@RequestParam Long commentId) : 코멘트의 모든 좋아요 반환

### POST
api/likes/createLike (body에 "comment"(코멘트 번호), "user"(유저 번호))) : 좋아요 생성 api

### DELETE
api/likes/delete/{commentId}/{userSeq} : 코멘트 삭제 api

## user

### GET
api/user/userinfo (@RequestParam Long userSeq) : 유저 번호로 유저정보 조회  

### POST
