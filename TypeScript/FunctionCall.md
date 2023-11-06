### function call 설명해보기

---

> Docs : In JavaScript, functions can have properties in addition to being callable. However, the function type expression syntax doesn’t allow for declaring properties. If we want to describe something callable with properties, we can write a call signature in an object type:
>
> > 호출 가능하면서, 어떤 속성을 가지는 함수인지를 표현하고 싶으면 call signature를 사용하면 된다!

---

### function call 만들어보기

---

```typescript
//call signature예시
type DescribableFunction = {
  description: string;
  (someArg: number): boolean;
};
function doSomething(fn: DescribableFunction) {
  console.log(fn.description + " returned " + fn(6));
}

//배열의 마지막 원소를 반환하는 last 함수
type Last<T> = (arr: T[]) => T;
const last: Last<any> = (arr) => {
  if (arr.length === 0) {
    return undefined;
  }
  return arr[length - 1];
};

const numberArray: number[] = [1, 2, 3, 4, 5];
const lastNumber: number = last(numberArray);
console.log(lastNumber);

//배열의 시작부분에 item 을 넣고 return 하는 prepend 함수
type Prepend<T> = (arr: T[], item: T) => T[];
const prepend: Prepend<any> = (arr, item) => {
  return [item, ...arr];
};

const originalArray: number[] = [2, 3, 4];
const prependedArray: number[] = prepend(originalArray, 1);
console.log(prependedArray);

//두개의 배열을 매개변수로 받고, 받은 두 배열을 섞어 하나의 배열로 반환하는 mix 함수
type Mix<T> = (arr: T[], arr2: T[]) => T[];
const mix: Mix<any> = (arr1, arr2) => {
  return [...arr1, ...arr2];
};

const mixarray1 = [1, 2, 3, 4];
const mixarray2 = [8, 8, 8, 8];
const result = mix(mixarray1, mixarray2);
console.log(result);

//배열을 배개변수로 받고, 배열의 길이를 반호나하는 count 함수
type baeyul<T> = (arr: T[]) => number;
const count: baeyul<any> = (arr) => {
  return arr.length;
};

// 첫번째 매개변수로 배열을 받고, 두번재 매개변수는 item 으로 받으며, item 이 첫번째 매개변수 배열의 몇번째 인덱스로 존재하는지 체크, 존재하면 몇번째 인덱스인지 반환

type FindIndex<T> = (arr: T[], item: T) => number | null;
const findIndex: FindIndex<any> = (arr, item) => {
  const index = arr.indexOf(item);
  return index !== -1 ? index : null;
};

//첫번째 매개변수로 배열을 받고, 두번째, 세번째 매개변수로 숫자를 받는다. 첫번째 받은 배열을 두번째~세번째 범위로 잘라 결과 반환. 세번째 매개변수는 옵션이다.

type Slice<T> = (arr: T[], startindex: number, endIndex?: number) => T[];
const slice: Slice<any> = (arr, startIndex, endIndex) => {
  if (endIndex === undefined) {
    return arr.slice(startIndex);
  } else {
    return arr.slice(startIndex, endIndex);
  }
};

//타입 선언과 함수 선언 예시2
type SuperPrint = {
  <T>(arr: T[]): T;
};
const superPrint: SuperPrint = (arr) => arr[0];
```

---

generic도 같이 써볼 수 있어서 좋았다. ㅎㅎ function call은 서버 개발을 하면서도 사용할 수 있을것같다.
(넘겨주는|넘어오는 객체의 형태 지정해주기와 같은 형태로!)
구조분해할당, .indexOf()가 굉장히 편하고 직관적이어서 재미있었다. :P
