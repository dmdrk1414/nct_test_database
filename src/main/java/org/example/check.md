# 엔티티 만들때 생각

1. @Data 추가
2. @Entity 추가
3. @Table(name = "MEMBER")
   1. 기본 생성자는 필수다파라미터가 없는 public 또는 protected 생성자.
   2. final 클래스, enum, interface, inner 클래스에는 사용할 수 없다.
   3. 저장할 필드에 final을 사용하면 안 된다.

```
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "attendance_check_time")
```

# 확인

- [x] TempUser 생년월일 Date으로 하고 , 테스트 코드만들
- [x] TempUser MBTI의 Enum 넣기
- [ ] AttendanceCheckTime에 enum 넣기
- [ ] 전체적으로 제약조건 넣기 (조건)
- [ ] Set 메서드 구현 (set 불가)

# 엔티티 체크

- [ ] 디폴트, 
- [ ] 클래스 전체에 Bilder하지말기
- [ ] @AllArgsConstructor 금지, Id을 생성하는 것을 막았다. 
- [ ] 래퍼럴 타입, enum 확인
- [ ] 제약 조건 확인
- [ ] LocalDate는 문자열로 getMethd String 보장
- [ ] id 없는 Builder 보장의 생성자 
- [ ] Set 메서드로 막아버리기

# 기본 엔티티 넣어야할꺼 

1. 등록 년월일 시간
2. 업데이트 년월일 시간





# 추가

