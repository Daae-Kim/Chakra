? BaseEntity란

```java
public class TeamEntity extends BaseEntity {
}
```
→ 어떤 데이터의 생성시간, 수정시간, 또는 생성한 사람, 마지막으로 수정한 사람을 저장해야할때가 있다.

많은 엔티티에 공통으로 필요한 컬럼이 있을때, 이를 BaseEntity로 만들어서 BaseEntity를 상속받도록 하면 편리하게 사용할 수 있다.

? PreRemove란

eventListener.(이벤트를 관찰하고 있다가 발생하면 특정 동작을 실행)

@PreRemove 는 엔티티를 영속성 컨텍스트에서 삭제하기 직전에 remove() 메소드를 호출한다. orphanRemoval에 대해서는 flush나 commit 시에 호출된다.

→ 엔티티를 영속성 컨텍스트에서 삭제하기 직전에 호출된다.

? Listener를 사용하는 이유

EntityListener는 엔티티 라이프 사이클 중 특정 시점에 원하는 로직을 처리하도록 한다.

만약 createAt 과 updateAt 이라는 속성을 대부분의 entity가 가지고 있고, 이 속성을 개발자가 insert, update때 마다 작성해줄 경우 실수등의 오류를 발생할 수 있는 요소가 된다. 
그러므로 prePersist, preUpdate 와 같은 listener 를 만들어두고 entity 에서 주입받아 사용한다.