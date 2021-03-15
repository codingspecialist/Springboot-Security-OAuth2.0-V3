# 스프링부트 블로그 프로젝트 V2

## 참고
- https://blog.naver.com/alsrb9434

## 의존성
- Spring Web
- ...
- ...

## DB 설정

```sql
create user 'pos'@'%' identified by 'pos1234';
GRANT ALL PRIVILEGES ON *.* TO 'pos'@'%';
create database pos;
```

```txt
{
  id=1661943466, 
  connected_at=2021-03-15T02:37:38Z, 
  properties={
    nickname=최주호, 
    profile_image=http://k.kakaocdn.net/dn/dLQ5Bl/btqYeaxBlPd/bsd1Bxfae0U6LZbyxdJFdk/img_640x640.jpg, 
    thumbnail_image=http://k.kakaocdn.net/dn/dLQ5Bl/btqYeaxBlPd/bsd1Bxfae0U6LZbyxdJFdk/img_110x110.jpg
  }, 
  kakao_account={
    profile_needs_agreement=false, 
    profile={
      nickname=최주호, 
      thumbnail_image_url=http://k.kakaocdn.net/dn/dLQ5Bl/btqYeaxBlPd/bsd1Bxfae0U6LZbyxdJFdk/img_110x110.jpg, 
      profile_image_url=http://k.kakaocdn.net/dn/dLQ5Bl/btqYeaxBlPd/bsd1Bxfae0U6LZbyxdJFdk/img_640x640.jpg
    }, 
    has_email=true, 
    email_needs_agreement=false, 
    is_email_valid=true, 
    is_email_verified=true, 
    email=ssarmango@gmail.com
  }
}


```