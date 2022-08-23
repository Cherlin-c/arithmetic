## 递归 

### 时间复杂度估算
#### master公式
- T(N) = a*T(N/b)+O(N^d)

1. log(b,a)>d =>复杂度为 O(N^log(b,a))
2. log(b,a)=d =>复杂度为 O(N^d * logN)
3. log(b,a)<d =>复杂度为 O(N^d)
```
a,b,d均为常量
a=一个方法中递归了几次
b=一次递归分了几部分
O(N^d)=除了递归方法之外的时间复杂度
log(b,a)是指以b为底，a的对数

```   
