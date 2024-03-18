# API 버저닝

api 버전은 major 와 minor 로 구분해 상황에 따라 버전을 관리한다.

### major versioning

이전 버전과 더 이상 호환되지 않는 경우, 클라이언트측의 코드가 변경되어야 하는 경우

1. API 삭제 혹은 API URL의 변경
2. API의 파라미터 삭제 및 파라미터명 변경
3. API의 내부 로직 변경
4. 예외처리된 에러코드가 변경되는 경우

### minor versioning

Major의 변경이 아닌 작은 변경사항이 있는 경우 Minor 버전을 올려야한다.

1. 버그 픽스
2. 추가되는 기능이 존재하지만 클라이언트의 코드의 변경이 필요하지 않은 경우(Optional 파라미터 추가 등)

When to Version

이전 버전과 하위호환을 깨는 큰 변화가 생겼을 경우 메이저를 수정하여 버전을 관리한다.

versioning Format

1. url path 에 버전 넘버를 포함하기
2. 요청의 쿼리 파라미터로 버전 넘버를 전달하는 것.

ex)

- URL path에 버전넘버 포함: https://api.contoso.com/**v1.0**/products/users
- 쿼리 파라미터로 버전넘버 전달: [https://api.contoso.com/products/users**?api-version=1.0**](https://api.contoso.com/products/users?api-version=1.0)